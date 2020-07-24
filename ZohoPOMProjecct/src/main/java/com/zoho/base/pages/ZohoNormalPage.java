package com.zoho.base.pages;

import com.zoho.web.WebConnector;

public interface ZohoNormalPage {
	
	ZohoPage navigateToHomePage();

	ZohoPage goToLoginPage();

	ZohoPage submitusername(String userid);

	void submitpassword(String pwd);

	WebConnector validator(boolean b);

}
