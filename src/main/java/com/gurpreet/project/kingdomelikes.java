package com.gurpreet.project;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.gurpreet.pages.HomePage;

public class kingdomelikes  extends BaseTest{

	WebDriverWait dynamicwait=new WebDriverWait(driver, 15);
	HomePage homePage=new HomePage(driver);


	@Test(priority=1)
	public void hitlike() throws InterruptedException{

		String facebookurl4="https://www.facebook.com/";
		driver.get(facebookurl4);
		Thread.sleep(5000);
		wops.waitForPageToLoad("facebook.com");
		homePage.clickFacebookEmail("karen4@w918bsq.com");
		homePage.clickFacebookPassword("sur39918102007");
		homePage.clickFacebookLogin();
		String kingdomlikes="http://kingdomlikes.com/";
		driver.get(kingdomlikes);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		wops.waitForPageToLoad("kingdomlikes.com");
		driver.findElement(By.xpath(".//input[@name='email']")).sendKeys("mortalglobe@gmail.com");
		driver.findElement(By.xpath(".//input[@name='password']")).sendKeys("sur39918102007");
		driver.findElement(By.xpath(".//*[@id='formlogin']/div[1]/input[3]")).click();
		wops.waitForPageToLoad("free_points");

		wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//div[@class='left socialmedia']/..")));
		driver.findElement(By.xpath(".//div[@class='left socialmedia']/..")).click();

		wops.waitForPageToLoad("facebook-likes");
		wops.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//button[@class='button blue'])[1]")));
		
		//Thread.sleep(5000);	
		driver.findElement(By.xpath("(.//button[@class='button blue'])[1]")).click();	
		String mainWindowHandle=driver.getWindowHandle();
		System.out.println("MainWindow Handle is "+mainWindowHandle);


		Set s = driver.getWindowHandles();
		Iterator ite = s.iterator();
		while(ite.hasNext())
		{
			String popupHandle=ite.next().toString();
			if(!popupHandle.contains(mainWindowHandle))
			{
				driver.switchTo().window(popupHandle);
				driver.switchTo().window(popupHandle);
				//Thread.sleep(3000);
				wops.waitForPageToLoad("facebook.com");
				driver.manage().window().maximize();
				try{
					driver.switchTo().window(popupHandle);
					System.out.println("I am here first time");
					wops.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[@id='pagesHeaderLikeButton']/../span/button")));
					
					System.out.println("Hiting Like");
					driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/../span/button")).click();
					System.out.println("Like Hited");
					Thread.sleep(9000);
					}
					catch (Exception e){
						System.out.println("Exception caught "+driver.switchTo().window(mainWindowHandle));
						continue;
					}
			}
		}
		Thread.sleep(3000);
		System.out.println("After"+driver.switchTo().window(mainWindowHandle));

		for(int k=0;k<2000;k++){
			System.out.println("Visiting again"+k);
			String kingdomlikes1="http://kingdomlikes.com/free_points/facebook-likes";
			System.out.println("Visiting http://kingdomlikes.com/free_points/facebook-likes");

			driver.get(kingdomlikes1);
			wops.waitForPageToLoad("facebook-likes");
			try{
			wops.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//button[@class='button blue'])[1]")));
			
			}
			catch (Exception e){
				driver.get(kingdomlikes1);
				wops.waitForPageToLoad("facebook-likes");
				wops.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//button[@class='button blue'])[1]")));
				
			}
			driver.findElement(By.xpath("(.//button[@class='button blue'])[1]")).click();	
			String mainWindowHandle1=driver.getWindowHandle();

			Set se = driver.getWindowHandles();
			Iterator iter = se.iterator();
			while(iter.hasNext())
			{
				String popupHandle1=iter.next().toString();
				if(!popupHandle1.contains(mainWindowHandle1))
				{
					System.out.println("I am here in 1st loop time "+k);
					driver.switchTo().window(popupHandle1);
					driver.switchTo().window(popupHandle1);
					wops.waitForPageToLoad("facebook.com");
					Thread.sleep(3000);
					driver.manage().window().maximize();
					try{
						driver.switchTo().window(popupHandle1);
					wops.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[@id='pagesHeaderLikeButton']/button")));
					
					System.out.println("Hiting Like");
					driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/button")).click();
					System.out.println("Like Hited");
					Thread.sleep(9000);
					}
					catch (Exception e){
						System.out.println("Exception caught "+driver.switchTo().window(mainWindowHandle1));
						continue;
					}
				}

			}
			Thread.sleep(3000);
			System.out.println("Bottom"+driver.switchTo().window(mainWindowHandle1));
		}
		
		for(int k=0;k<2000;k++){
			System.out.println("Visiting again"+k);
			String kingdomlikes1="http://kingdomlikes.com/free_points/facebook-likes";
			System.out.println("Visiting http://kingdomlikes.com/free_points/facebook-likes");

			driver.get(kingdomlikes1);
			wops.waitForPageToLoad("facebook-likes");
			try{
			wops.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//button[@class='button blue'])[1]")));
			
			}
			catch (Exception e){
				driver.get(kingdomlikes1);
				wops.waitForPageToLoad("facebook-likes");
				wops.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//button[@class='button blue'])[1]")));
				
			}
			wops.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//button[@class='button blue'])[1]")));
			driver.findElement(By.xpath("(.//button[@class='button blue'])[1]")).click();	
			String mainWindowHandle1=driver.getWindowHandle();

			Set se = driver.getWindowHandles();
			Iterator iter = se.iterator();
			while(iter.hasNext())
			{
				String popupHandle1=iter.next().toString();
				if(!popupHandle1.contains(mainWindowHandle1))
				{
					System.out.println("I am here in 2nd loop time "+k);
					driver.switchTo().window(popupHandle1);
					driver.switchTo().window(popupHandle1);
					wops.waitForPageToLoad("facebook.com");
					//driver.findElement(By.xpath(".//a[starts-with(.,'Log In')]")).click();
					//driver.findElement(By.xpath(".//a[starts-with(.,'Log In')]")).sendKeys("testidtvt@gmail.com");
					Thread.sleep(3000);
					driver.manage().window().maximize();
					try{
						driver.switchTo().window(popupHandle1);
					wops.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[@id='pagesHeaderLikeButton']/button")));
					
					System.out.println("Hiting Like");
					driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/button")).click();
					System.out.println("Like Hited");
					Thread.sleep(9000);
					//driver.findElement(By.xpath(".//span[starts-with(.,'Like')]/..")).click();;
					//System.out.println("Before"+driver.switchTo().window(mainWindowHandle));
					}
					catch (Exception e){
						System.out.println("Exception caught "+driver.switchTo().window(mainWindowHandle1));
						continue;
					}
				}

			}
			Thread.sleep(3000);
			System.out.println("Bottom"+driver.switchTo().window(mainWindowHandle1));
		}
	}


}





