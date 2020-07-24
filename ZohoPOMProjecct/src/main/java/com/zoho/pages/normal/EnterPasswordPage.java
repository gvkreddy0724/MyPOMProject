package com.zoho.pages.normal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBasePage;


public class EnterPasswordPage extends ZohoBasePage{
	
	@FindBy(id = Constants.Password_Field)
	WebElement passwordfield;
	@FindBy(id = Constants.Submit_Button)
	WebElement submitbutton;
	
	
	
	public void submitpassword(String pwd) {
		
		passwordfield.sendKeys(pwd);
		log("Entered password");
		submitbutton.click();
		log("Logged in successfully");
		
		
		
	}

}
