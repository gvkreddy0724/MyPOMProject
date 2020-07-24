package com.zoho.web;

import org.openqa.selenium.By;

import com.zoho.base.pages.ZohoPage;

public interface ZohoWebConnector {
	
	void logout();
	ZohoPage validateTitle(String expectedTitle);
	void validateLogin();
	boolean isElementpresent(By locator);
	
	
	void openbrowser(String browser);
	void navigate(String URL);
	void quit();
	ZohoPage validateElementPresent(By locator);
	
	

}
