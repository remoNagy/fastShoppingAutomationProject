package com.fastshopping.pages;

import io.appium.java_client.android.AndroidDriver;
import com.fastshopping.utility.*;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseClass {
	public AndroidDriver driver;
	public ConfigDataProvider config;
	public WebDriverWait wait;
	public Helper helper;

	@BeforeSuite
	public void setUpSuite() {
		config = new ConfigDataProvider();
		helper = new Helper();
	}

	@BeforeClass
	public void driverSetup() {
		driver = DriverFactory.getDriver(config.getDataFromConfig("PlatformName"),
				config.getDataFromConfig("PlatformVersion"), config.getDataFromConfig("DeviceName"),
				config.getDataFromConfig("AutomationName"), config.getDataFromConfig("AndroidDriverURL"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getDataFromConfig("timeout"))));
	}

	@AfterClass
	public void driverTearDown() {
		DriverFactory.quitDriver();
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			helper.captureScreenShot(driver);
		}
	}

}
