package com.zoho.pages.normal;

import org.openqa.selenium.support.PageFactory;

import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;
import com.zoho.session.ZohoTestSession;

public class LaunchPage extends ZohoBasePage {
	
	public LaunchPage() {
		System.out.println("LaunchPage constructor");
		
//		PageFactory.initElements(getCurrentDriver(), this);
	}
	
	

	public ZohoPage openbrowser(String browser) {
//		ZohoTestSession session=getsession();        //instead of writing these 2 lines write as below
//		session.getcon().openbrowser("browser");
		getDriver().openbrowser("browser");
		log("Browser opened");
		return this;

	}

	public ZohoPage navigateToHomePage() {

		System.out.println("homepage");

		getDriver().navigate("https://zoho.com");
//		
////		getsession().getcon().navigate("http://zoho.com");
		
		log("Navigated to Homepage");
//		
		return new Homepage();

	}

}
