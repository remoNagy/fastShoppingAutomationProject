package com.fastshopping.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() {
		File src = new File("./Configuration/Config.properties");
		try (FileInputStream fis = new FileInputStream(src)) {
			pro = new Properties();
			pro.load(fis);

		} catch (IOException e) {
			throw new RuntimeException("Failed to load Properties file: " + e.getMessage(), e);
		}
	}

	public String getDataFromConfig(String Key) {
		return pro.getProperty(Key);
	}

}
