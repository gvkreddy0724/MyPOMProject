package com.zoho.base.pages;

import org.openqa.selenium.By;

public class Constants {
	
	public static final String Login_Link="a.zh-login";
	public static final By Login_Link_Locator=By.cssSelector(Login_Link);
	
	public static final String Email_Field="login_id";
	public static final By Email_Field_Locator=By.id(Email_Field);
	
	public static final String Next_Button="nextbtn";
	public static final By Next_Button_Locator=By.id(Next_Button);
	
	
	public static final String Password_Field="password";
	public static final By Password_Field_Locator=By.id(Password_Field);
	
	public static final String Submit_Button="nextbtn";
	public static final By Submit_Button_Locator=By.id(Submit_Button);
	
	
	
	
	
	//Titles
	public static final String HomePage_Title = "Zoho - Cloud Software Suite and SaaS Applications for Businesses";
	
	
	
	
	//Reports
	
	public static final String Report_Path=System.getProperty("user.dir")+"//reports//";

	

	


	
	

}
