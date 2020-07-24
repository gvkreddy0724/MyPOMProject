package com.zoho.pages.normal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;


public class Homepage extends ZohoBasePage {
	
	public Homepage() {
		
//		PageFactory.initElements(getCurrentDriver(), this);
	}
	
	@FindBy(css = Constants.Login_Link)
	WebElement loginlink;

	public ZohoPage goToLoginPage() {
		
		loginlink.click();
		log("Naviagated to loginpage");
		return new EnterUserNamePage();
		

	}

}
