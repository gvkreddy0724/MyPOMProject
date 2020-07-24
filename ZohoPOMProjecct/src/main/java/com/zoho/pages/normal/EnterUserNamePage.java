package com.zoho.pages.normal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;


public class EnterUserNamePage extends ZohoBasePage{
	
	@FindBy(id = Constants.Email_Field)
	WebElement emailfield;
	@FindBy(id = Constants.Next_Button)
	WebElement nextbutton;
	
	public ZohoPage submitusername(String userid) {
		
		emailfield.sendKeys(userid);
		nextbutton.click();
		log("Entered usename");
		return new EnterPasswordPage();
		
		
	}
	
	

}
