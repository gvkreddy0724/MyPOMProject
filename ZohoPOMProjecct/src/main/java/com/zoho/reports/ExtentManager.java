package com.zoho.reports;

import java.io.File;
import java.util.Date;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports reports;
	public static String screenshotFolderPath;

	public static ExtentReports getInstance(String reportpath) {
		if (reports == null) {
			// generate report path
			String filename = "report.html";
			Date d = new Date();
			String foldername = d.toString().replace(":", "_");

			// directory of report folder

			new File(reportpath+foldername+"//screenshots").mkdirs();
			reportpath = reportpath+foldername+"//";
			screenshotFolderPath = reportpath+"screenshots//";
			System.out.println(reportpath + filename);
			createInstance(reportpath + filename);

		}
		return reports;

	}
	
	public static ExtentReports createInstance( String filename) {
		ExtentHtmlReporter htmlreporter=new ExtentHtmlReporter(filename);
		htmlreporter.config().setTheme(Theme.STANDARD);
		htmlreporter.config().setDocumentTitle("Reports");
		htmlreporter.config().setEncoding("utf-8");
		htmlreporter.config().setReportName("Reports-Automation");
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		return reports;
	}

}
