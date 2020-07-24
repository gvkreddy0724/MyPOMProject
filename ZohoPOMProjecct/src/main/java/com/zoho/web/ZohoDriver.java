package com.zoho.web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.zoho.listener.ZohoEventListener;

public class ZohoDriver extends ZohoValidationDriver {

	public void logout() {
		// TODO Auto-generated method stub

	}

	public void openbrowser(String browser) {

		driver = new EventFiringWebDriver(new FirefoxDriver());
		driver.register(new ZohoEventListener());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		log("opened the browser"+browser);

	}

	public void navigate(String URL) {

		driver.get(URL);
		
		log("url is "+URL);

	}

	public void quit() {
		// TODO Auto-generated method stub

	}

	public EventFiringWebDriver getCurrentDriver() {

		return driver;

	}

	public void waitForElementLoad() {
		// TODO Auto-generated method stub

	}

	public void log(String message) {

		getsession().log(message);

	}

}
