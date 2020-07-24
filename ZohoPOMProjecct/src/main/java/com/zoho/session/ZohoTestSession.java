package com.zoho.session;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoPage;
import com.zoho.pages.normal.LaunchPage;
import com.zoho.reports.ExtentManager;
import com.zoho.web.WebConnector;
import com.zoho.web.ZohoDriver;

import zmq.ZError.IOException;

public class ZohoTestSession {

	WebConnector con;
	ZohoPage currentPage; // current page
	ExtentReports reports;
	ExtentTest test;

	public ZohoPage getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(ZohoPage currentPage) {
		this.currentPage = currentPage;
	}

	public ZohoTestSession() {
		con = new ZohoDriver();
	}

	public ZohoPage init(String testName) {

		if (Reporter.getCurrentTestResult().getTestContext().getAttribute("session") == null)

			Reporter.getCurrentTestResult().getTestContext().setAttribute("session", this);

		// initialize reports

		reports = ExtentManager.getInstance(Constants.Report_Path);
		test = reports.createTest(testName);

//		ZohoPage page = new LaunchPage();
		return new LaunchPage();
	}

	public WebConnector getcon() {
		return con;
	}

	public void end() {

		getcon().assertAll();

	}

	public void log(String message) {

		test.log(Status.INFO, message);

	}

	public void generateReports() {
		reports.flush(); /// generate html reports using this function
	}

	public void failTest(String FailureMessage) { // fail it in extent reports
		
		takeScreenshot();

		test.log(Status.FAIL, FailureMessage);

		// take screenshot

	}

	public void takeScreenshot() {

		// Filename of screenshot
		Date d = new Date();
		String screenshotfile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		// takescreenshot
		File srcFile = ((TakesScreenshot) getcon().getCurrentDriver()).getScreenshotAs(OutputType.FILE);

		
			

			try {
				// get dynamic foldername
				FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath + screenshotfile));
			} catch (java.io.IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				// put screenshotfile in reports

				test.log(Status.FAIL, "Screenshot-->"+ test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath + screenshotfile));
			} catch (java.io.IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		}

	}


