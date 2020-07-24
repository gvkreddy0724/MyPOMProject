package com.zoho.base.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.zoho.session.ZohoTestSession;
import com.zoho.web.WebConnector;

public class ZohoBasePage implements ZohoPage {

	public ZohoBasePage() {    //page object is created
		
		System.out.println("ZohoBasePage constructor");

		PageFactory.initElements(getCurrentDriver(), this);

		getsession().setCurrentPage(this);
		
		//getsession().takeScreenshot(); //screenshot will be captured
	}

	public ZohoPage openbrowser(String browser) {
		return null;
		// TODO Auto-generated method stub

	}

	public void quit() {
		// TODO Auto-generated method stub

	}

	public void getTotalWindows() {
		// TODO Auto-generated method stub

	}

	public ZohoPage navigateToHomePage() {
		return null;

		// TODO Auto-generated method stub

	}

	public ZohoPage goToLoginPage() {
		return null;
		// TODO Auto-generated method stub

	}

	public ZohoPage submitusername(String userid) {
		return null;
		// TODO Auto-generated method stub

	}

	public void submitpassword(String pwd) {
		// TODO Auto-generated method stub

	}

	public WebConnector validator(boolean stopExecution) {
		// update the flag in weblayer

		getsession().getcon().setStopExecution(stopExecution);

		return getsession().getcon();

	}

	public void createdeal() {
		// TODO Auto-generated method stub

	}

	public void logout() {
		// TODO Auto-generated method stub

	}

	public ZohoTestSession getsession() {

		return (ZohoTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}

	public WebConnector getDriver() {

		return getsession().getcon();
	}

	public EventFiringWebDriver getCurrentDriver() {

		return getsession().getcon().getCurrentDriver();
	}
	
	public void log(String message) {
		
		getsession().log(message);
		
	}

	

}
