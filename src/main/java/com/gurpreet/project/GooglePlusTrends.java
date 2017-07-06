package com.gurpreet.project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.gurpreet.pages.HomePage;

public class GooglePlusTrends extends BaseTest {

	WebDriverWait dynamicwait=new WebDriverWait(driver, 15);
	HomePage homePage=new HomePage(driver);


	@Test(priority=1)
	public void googlplustrends() throws InterruptedException{

	
		driver.get("https://plus.google.com/explore");
		wops.waitForPageToLoad("explore");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//a[starts-with(.,'Sign in')]")).click();
		driver.findElement(By.xpath(".//*[@id='Email']")).click();
		driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys("mortalglobe@gmail.com");
		driver.findElement(By.xpath(".//*[@id='next']")).click();
		wops.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='Passwd']")));
		driver.findElement(By.xpath(".//*[@id='Passwd']")).sendKeys("sur39918102007");
		driver.findElement(By.xpath(".//*[@id='signIn']")).click();
		wops.waitForPageToLoad("explore");
		Thread.sleep(9000);
		
		Set<String> trends = new HashSet<>();
		for(int i=1;i<=5;i++){
			trends.add(driver.findElement(By.xpath(".//span[starts-with(.,'Trending')]/../../../div[2]/div[1]/div/ul/li["+i+"]/div/span")).getText());
			trends.add(driver.findElement(By.xpath(".//span[starts-with(.,'Trending')]/../../../div[2]/div[2]/div/ul/li["+i+"]/div/span")).getText());
			
		}
		
		System.out.println("trends are "+trends);
		
		/*driver.findElement(By.xpath(".//span[starts-with(.,'Trending')]/../../../div[2]/div[1]/div/ul/li[1]/div/span/a")).click();
		wops.waitForPageToLoad("explore");
		Thread.sleep(4000);
		
		trends.add(driver.findElement(By.xpath(".//h3[starts-with(.,'#')]/../../div[2]/div[1]/div/ul/li[1]/div/span")).getText());
		trends.add(driver.findElement(By.xpath(".//h3[starts-with(.,'#')]/../../div[2]/div[2]/div/ul/li[1]/div/span")).getText());
		System.out.println("Here are category Trends"+ trends);
		*/
		for(int i=1;i<=5;i++){
			
			System.out.println("Here is i "+i);
		driver.findElement(By.xpath(".//span[starts-with(.,'Trending')]/../../../div[2]/div[1]/div/ul/li["+i+"]/div/span/a")).click();
		wops.waitForPageToLoad("explore");
		Thread.sleep(4000);
		
		//ArrayList<String> trendscategory=new ArrayList<>();
		for(int j=1;j<=10;j++){
			
			System.out.println("In side J Loop ,i is "+i);
			System.out.println("In side J Loop ,j is "+j);
			trends.add(driver.findElement(By.xpath(".//h3[starts-with(.,'#')]/../../div[2]/div[1]/div/ul/li["+j+"]/div/span")).getText());
			System.out.println("2nd element for i "+i);
			System.out.println("2nd element for j "+j);
			trends.add(driver.findElement(By.xpath(".//h3[starts-with(.,'#')]/../../div[2]/div[2]/div/ul/li["+j+"]/div/span")).getText());
		}
		System.out.println("trends category are "+" times "+trends);
		driver.navigate().back();
		wops.waitForPageToLoad("explore");
		Thread.sleep(7000);
		
		
		}
	
		//comment
		
		
		
		
	}
}
