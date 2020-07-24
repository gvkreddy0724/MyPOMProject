package com.zoho.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoPage;
import com.zoho.listener.ZohoEventListener;
import com.zoho.reports.ExtentManager;
import com.zoho.session.ZohoTestSession;
import com.zoho.web.ZohoDriver;
import com.zoho.web.ZohoWebConnector;

public class LoginTest {

	ZohoTestSession session;

	@BeforeMethod

	public void init() {

		session = new ZohoTestSession();

	}

	@AfterMethod

	public void quit() {

		session.generateReports();

	}

	@Test
	public void loginTest() {

//		ZohoPage page = 
				session.init("LoginTest"). // all are returning same zohopage so, will write like this
				openbrowser("firefox").navigateToHomePage().validator(false).validateTitle(Constants.HomePage_Title)
				.goToLoginPage().submitusername("vamshi.gsr@gmail.com").submitpassword("N@ni0724");

		session.end();

	}

}
