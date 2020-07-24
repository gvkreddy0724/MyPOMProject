package com.zoho.web;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.zoho.base.pages.ZohoPage;
import com.zoho.session.ZohoTestSession;

public abstract class ZohoValidationDriver implements WebConnector {

	EventFiringWebDriver driver;
	boolean stopExecution;
	SoftAssert sa = new SoftAssert();

	public boolean isStopExecution() {
		return stopExecution;
	}

	public void setStopExecution(boolean stopExecution) {
		this.stopExecution = stopExecution;
	}

	public ZohoPage validateTitle(String expTitle) {

		log("expected Title is " + expTitle);
		log("actual Title is " + driver.getTitle());

		System.out.println("status is " + isStopExecution());
//		Assert.assertEquals(driver.getTitle(), expTitle);
		if (!(expTitle.equalsIgnoreCase(driver.getTitle()))) {

			fail("Title not matching" + driver.getTitle());

		}

		// return back the current page object
		return getsession().getCurrentPage();

	}

	public void validateLogin() {
		// TODO Auto-generated method stub

	}

	public ZohoTestSession getsession() {

		return (ZohoTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}

	public void assertAll() {// control will come to stop the test..because of some critical error

		// may be we can take the screenshot
		sa.assertAll();

	}

	public SoftAssert getSa() {
		return sa;
	}

	public void setSa(SoftAssert sa) {
		this.sa = sa;
	}

	public ZohoPage validateElementPresent(By locator) {

		if (!isElementpresent(locator))
			fail("Element Not Present-" + locator);

		return getsession().getCurrentPage();

	}

	public ZohoPage validateElementNotPresent(By locator) {

		if (isElementpresent(locator))
			fail("Element Not Present-" + locator);

		return getsession().getCurrentPage();

	}

	// return True-present/False-NotPresent
	public boolean isElementpresent(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

		} catch (org.openqa.selenium.TimeoutException e) {

			return false;
		}

		return true;
	}

	public void fail(String message) {

		// fail in extent report
		getsession().failTest(message);
		// fail it in TestNG

		sa.fail();
		// decide if execution has to be stopped

		if (isStopExecution())
			assertAll();

	}

}
