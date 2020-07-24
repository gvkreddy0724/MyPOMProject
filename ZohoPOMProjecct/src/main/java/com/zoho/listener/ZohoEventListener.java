package com.zoho.listener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

import com.zoho.session.ZohoTestSession;
import com.zoho.web.WebConnector;

public class ZohoEventListener extends AbstractWebDriverEventListener {

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {

		System.out.println("Beforefinding By" + by);
		System.out.println("Beforefinding WebElement" + element);
		System.out.println("Beforefinding WebDriver" + driver);
		boolean err = false;
		if (err) {
			getDriver().fail("element not found" + by);
			getDriver().assertAll(); //end the flow of the test
		}
		

	}

	public WebConnector getDriver() {

		return getsession().getcon();
	}

	public ZohoTestSession getsession() {

		return (ZohoTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}
	
	public void log(String message) {

		getsession().log(message);

	}
}
