package com.zoho.web;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.zoho.session.ZohoTestSession;

public interface WebConnector extends ZohoWebConnector {
	
	void openbrowser(String browser);
	void navigate(String URL);
	void quit();
	EventFiringWebDriver getCurrentDriver();
	void waitForElementLoad();
	ZohoTestSession getsession();
	boolean isStopExecution();
	void setStopExecution(boolean stopExecution);
	void assertAll();
	SoftAssert getSa();
	void setSa(SoftAssert sa);
	void log(String message);
	void fail(String message);
	

}
