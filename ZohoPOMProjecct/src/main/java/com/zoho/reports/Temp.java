package com.zoho.reports;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Temp {

	public static void main(String[] args) {
		
		Date d = new Date();
		
		System.out.println(d.toString().replace(":", "_"));
		
		ExtentReports rep= ExtentManager.getInstance("C:\\Selenium\\CucumberFrameWorkDevelopment");
		ExtentTest test= rep.createTest("TestA");
		test.log(Status.INFO, "Starting TestA");
		test.log(Status.INFO, "executing");
		test.log(Status.FAIL, "Failed");
		rep.flush();
		

	}

}
