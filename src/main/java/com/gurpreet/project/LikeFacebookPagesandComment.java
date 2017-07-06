package com.gurpreet.project;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LikeFacebookPagesandComment extends BaseTest{
	
	WebDriverWait dynamicwait=new WebDriverWait(driver, 15);
	HomePage homePage=new HomePage(driver);

	@Test
	public void LikeandComment(){
	String facebookurl="https://www.facebook.com/";
	driver.get(facebookurl);
	System.out.println("Here");
	driver.manage().window().maximize();
	System.out.println("Now Here");
	wops.waitForPageToLoad("facebook.com");
	
	homePage.clickFacebookEmail("karen4@w918bsq.com");
	homePage.clickFacebookPassword("sur39918102007");
	homePage.clickFacebookLogin();
	driver.manage().window().maximize();
	wops.waitForPageToLoad("facebook.com");
	driver.manage().window().maximize();
	
	List namepages=new ArrayList<>();
	namepages.add("Dainik Jagran");
	namepages.add("Dainik Bhaskar");
	namepages.add("Punjab Kesari");
	namepages.add("Aaj Tak");
	namepages.add("India TV");
	namepages.add("NDTV");

	
	for(int k=1;k<namepages.size()-1;k++){
		homePage.FacebookSearch.clear();
		homePage.FacebookSearch.click();
		Actions builder =new Actions(driver);
		builder.sendKeys(Keys.chord(Keys.CONTROL,"a")).build().perform();
		builder.sendKeys(Keys.DELETE);
		homePage.FacebookSearch.clear();
		homePage.FacebookSearch.click();
		homePage.FacebookSearch.clear();
		homePage.clickFacebookSearch(namepages.get(k).toString());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		homePage.FacebookSearch.click();
		homePage.FacebookSearch.click();
		homePage.FacebookSearch.sendKeys(Keys.END);
		homePage.FacebookSearch.click();
		//wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")));
		//Thread.sleep(9000);

		try{
			wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")));
			if(driver.findElement(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")).isDisplayed())
			{

				driver.findElement(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")).click();	
			}
		}
		catch (Exception e){
			continue;
		}
		
		try{
			
			wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")));
			if (driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")).isDisplayed()) {
				driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")).click();

	}
		}
			catch(Exception e){
				}
			}
}
}
