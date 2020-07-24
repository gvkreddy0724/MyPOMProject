package com.zoho.base.pages;

import com.zoho.session.ZohoTestSession;
import com.zoho.web.WebConnector;
import com.zoho.web.ZohoValidationDriver;

public interface ZohoPage extends ZohoNormalPage,ZohoSessionPage {

	// browser based
	ZohoPage openbrowser(String browser);

	void quit();

	void getTotalWindows();

	// Normal functions

	ZohoPage navigateToHomePage();

	ZohoPage goToLoginPage();

	ZohoPage submitusername(String userid);

	void submitpassword(String pwd);

	WebConnector validator(boolean flagAssertionType);

	// session based

	void createdeal();

	void logout();
	
	 ZohoTestSession getsession();
	 
	 void log(String message);

	

}
