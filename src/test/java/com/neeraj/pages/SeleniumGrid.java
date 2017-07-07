package com.neeraj.pages;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumGrid {

	public WebDriver driver1;
	@BeforeClass
	public void setup() throws MalformedURLException{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		driver1=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		//driver1.get("http://newtours.demoaut.com/");
	}
	
	@Test
	public void testing(){
		driver1.get("http://newtours.demoaut.com/");
		driver1.findElement(By.xpath(".//input[@name='userName']")).click();
		driver1.findElement(By.xpath(".//input[@name='userName']")).sendKeys("hello");
		
	}
}
