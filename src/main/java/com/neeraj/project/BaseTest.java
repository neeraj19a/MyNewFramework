package com.neeraj.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    public static WebDriver driver = new FirefoxDriver();
    public static WebDriverOperations wops = new WebDriverOperations();
}
