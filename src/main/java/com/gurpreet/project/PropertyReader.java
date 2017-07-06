package com.gurpreet.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.File;

public class PropertyReader {

	Properties prop = new Properties();

	public Properties bringObjectProperty() throws IOException {
		FileInputStream stream = new FileInputStream(new File(
				System.getProperty("user.dir")
						+ "\\src\\main\\java\\resources\\config.properties"));
		prop.load(stream);

		System.out.println("Here is property from config file-->" + prop.getProperty("enviornment"));
		return prop;
	}
}
