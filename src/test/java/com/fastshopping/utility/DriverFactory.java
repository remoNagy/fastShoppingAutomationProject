
package com.fastshopping.utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;

public class DriverFactory {
	private static AndroidDriver driver;

	public static AndroidDriver getDriver(String PlatformName,String Version,String DeviceName,String AutomationName,String serverURL) {
		if (driver == null) {
			try {
				UiAutomator2Options options = new UiAutomator2Options();
				options.setPlatformName(PlatformName);
				options.setPlatformVersion(Version);
				options.setDeviceName(DeviceName);
				options.setAutomationName(AutomationName);
				options.setApp("./Apps/fastshopping.apk");

				driver = new AndroidDriver(new URL(serverURL), options);
			} catch (Exception e) {
				throw new RuntimeException("Failed to initialize Appium Driver: " + e.getMessage());
			}
		}
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
