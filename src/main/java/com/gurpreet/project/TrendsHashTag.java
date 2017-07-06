package com.gurpreet.project;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class TrendsHashTag  extends BaseTest{

	WebDriverWait dynamicwait=new WebDriverWait(driver, 15);
	HomePage homePage=new HomePage(driver);


	@SuppressWarnings({ "null" })
	@Test
	public void generateHashTags() throws InterruptedException{

		String facebookurl4="https://www.facebook.com/";
		driver.get(facebookurl4);
		driver.manage().window().maximize();

		Thread.sleep(5000);
		wops.waitForPageToLoad("facebook.com");
		homePage.clickFacebookEmail("paul6@a54pd15op.com");
		homePage.clickFacebookPassword("sur39918102007");
		homePage.clickFacebookLogin();
		wops.waitForPageToLoad("facebook.com");
		List<WebElement> trends;
		List<WebElement> politics;
		List<WebElement> science;
		List<WebElement> sports;
		List<WebElement> entertainment;


		Set<String> nametrends = new HashSet<String>(); 

		Thread.sleep(4000);
		try{
			if(driver.findElement(By.xpath(".//a[@data-position='seemore']")).isDisplayed()){
				driver.findElement(By.xpath(".//a[@data-position='seemore']")).click();
				Thread.sleep(4000);
			}
		}
		catch (Exception e) {

		}
		Thread.sleep(4000);
		trends=driver.findElements(By.xpath(".//button[@aria-label='Hide Trending Item']/../../a/div/span[1]"));
		for(int i=0;i<trends.size()-1;i++){
			nametrends.add("#"+trends.get(i).getText().replaceAll(" ", "").replaceAll("[\\-\\_\\<.*?>]", "").replaceAll("\\,", " #"));
			nametrends.add("#"+trends.get(i).getText().replaceAll(" ", "").replaceAll("[\\-\\_\\<.*?>]", "").replaceAll("\\,", " #"));
		}

		Thread.sleep(3000);
		driver.findElement(By.xpath(".//a[@aria-label='Politics']")).click();
		try{
			if(driver.findElement(By.xpath(".//a[@data-position='seemore']")).isDisplayed()){
				driver.findElement(By.xpath(".//a[@data-position='seemore']")).click();
				Thread.sleep(4000);
			}
		}
		catch (Exception e) {

		}

		Thread.sleep(3000);
		politics=driver.findElements(By.xpath(".//button[@aria-label='Hide Trending Item']/../../a/div/span[1]"));
		for(int i=0;i<politics.size()-1;i++){
			nametrends.add("#"+politics.get(i).getText().replaceAll(" ", "").replaceAll("[\\-\\_\\<.*?>]", "").replaceAll("\\,", " #"));
			nametrends.add("#"+politics.get(i).getText().replaceAll(" ", "").replaceAll("[\\-\\_\\<.*?>]", "").replaceAll("\\,", " #"));
		}

		System.out.println("Here is 1st list"+nametrends);

		Thread.sleep(3000);
		driver.findElement(By.xpath(".//a[@aria-label='Science and Technology']")).click();
		try{
			if(driver.findElement(By.xpath(".//a[@data-position='seemore']")).isDisplayed()){
				driver.findElement(By.xpath(".//a[@data-position='seemore']")).click();
				Thread.sleep(4000);
			}
		}
		catch (Exception e) {

		}
		Thread.sleep(3000);
		science=driver.findElements(By.xpath(".//button[@aria-label='Hide Trending Item']/../../a/div/span[1]"));
		for(int i=0;i<science.size()-1;i++){
			nametrends.add("#"+science.get(i).getText().replaceAll(" ", "").replaceAll("[\\-\\_\\<.*?>]", "").replaceAll("\\,", " #"));
			nametrends.add("#"+science.get(i).getText().replaceAll(" ", "").replaceAll("[\\-\\_\\<.*?>]", "").replaceAll("\\,", " #"));
		}


		System.out.println("Here is 2nd list"+nametrends);
		driver.findElement(By.xpath(".//a[@aria-label='Sports']")).click();
		try{
			if(driver.findElement(By.xpath(".//a[@data-position='seemore']")).isDisplayed()){
				driver.findElement(By.xpath(".//a[@data-position='seemore']")).click();
				Thread.sleep(4000);
			}
		}
		catch (Exception e) {

		}
		Thread.sleep(3000);
		sports=driver.findElements(By.xpath(".//button[@aria-label='Hide Trending Item']/../../a/div/span[1]"));
		for(int i=0;i<sports.size()-1;i++){
			nametrends.add("#"+sports.get(i).getText().replaceAll(" ", "").replaceAll("[\\-\\_\\<.*?>]", "").replaceAll("\\,", " #"));
			nametrends.add("#"+sports.get(i).getText().replaceAll(" ", "").replaceAll("[\\-\\_\\<.*?>]", "").replaceAll("\\,", " #"));
		}


		System.out.println("Here is 3rd list"+nametrends);
		driver.findElement(By.xpath(".//a[@aria-label='Entertainment']")).click();
		try{
			if(driver.findElement(By.xpath(".//a[@data-position='seemore']")).isDisplayed()){
				driver.findElement(By.xpath(".//a[@data-position='seemore']")).click();

				Thread.sleep(4000);
			}
		}
		catch (Exception e) {

		}
		Thread.sleep(3000);
		entertainment=driver.findElements(By.xpath(".//button[@aria-label='Hide Trending Item']/../../a/div/span[1]"));
		for(int i=0;i<entertainment.size()-1;i++){
			nametrends.add("#"+entertainment.get(i).getText().replaceAll(" ", "").replaceAll("[\\-\\_\\<.*?>]", "").replaceAll("\\,", " #"));
			nametrends.add("#"+entertainment.get(i).getText().replaceAll(" ", "").replaceAll("[\\-\\_\\<.*?>]", "").replaceAll("\\,", " #"));
		}

		Iterator<String> ite=nametrends.iterator();
		while(ite.hasNext()){
			System.out.println("List of elements"+ite.next());
		}

		System.out.println("Size is "+nametrends.size());

		String Trends=nametrends.toString().replace("[", "").replace("]", "").replaceAll("##", "#");
		System.out.println("Trends are "+Trends);

		//#PostHere

		String Illuminati="HISTORY AND FACTS FROM ORIGIN TILL END OF ILLUMINATI: THE SECRET RELIGION \n";
		String IlluminatiURLTrends=" http://goo.gl/golGyy\n"+"\n"+Trends;
		String IlluminatiHashTags=	"‪#IlluminatiConfirmed #NWO #Freemasonry #Turkey #Thanksgiving #Masonic #FakeLivesMatter #Satanic #GeorgeWashington #Ring #Jewelry #Wealth #Obama #Poverty #RealEstateInvestments #Bible #God #POTUS #Jesus #MKUltra  #chemtrails   #AdamWeishaupt   #JewishConspiracy #AdamWeishaupt, #BavarianGovernment, #MultipleAnons, #Video - #Anonymous #Conspiracy #Newspiracy﻿\n";
		
		String IlluminatiSymbols="SYMBOLS OF ILLUMINATI AND THEIR MEANINGS \n";
		String IlluminatiSymbolsURLTrends=" http://goo.gl/FAiF4A\n"+"\n"+Trends;
		String IlluminatiSymbolsHashTags=	"‪#IlluminatiConfirmed #NWO #Freemasonry #Turkey #Thanksgiving #Masonic #FakeLivesMatter #Satanic #GeorgeWashington #Ring #Jewelry #Wealth #Obama #Poverty #RealEstateInvestments #Bible #God #POTUS #Jesus #MKUltra  #chemtrails   #AdamWeishaupt   #JewishConspiracy #AdamWeishaupt, #BavarianGovernment, #MultipleAnons, #Video - #Anonymous #Conspiracy #Newspiracy﻿\n";

		String BurningMan="BURNING MAN FESTIVAL, FACTS, HISTORY,PRINCIPLES AND PHOTOS OF NEVADA DESERT ARTS FESTIVAL \n";
		String BurningManURLTrends=" http://goo.gl/DgZFL8\n"+"\n"+Trends;
		String BurningManHashTags=	"‪	#Art #Nevada #SoundCloud #Sculpture #NP #Playa #BRC #Psychedelic #EDM #ARTIST #Steampunk #BlackRockCity #Painting #Psytrance #PSY #MickeyMouse #Fashion #Trance #Festival#News #Photography #EntertainmentNews #BurningMan #BRC #Nevada #Playa #BlackRockDesert #BurningMan2015 #Bugs #Burners #Festival #Art #Desert #Sculpture #MusicFestival #Community #SanFrancisco #Livestream  #dontfencemein #bestburningmanphotos  #carnivalofmirrors #stiltwalkers #veganburner #vegantravel #veganswhotravel   #goodmusic #bestvibes﻿ #interestingfacts #annual #festival  #leicam240 #leica #burningman #burner #leicam #burnergirls #brc﻿\n";
		
		
		String STPatrick="ST. PATRICK’S DAY HISTORY,FUN FACTS,SYMBOLS AND WHAT THEY MEAN \n";
		String STPatrickURLTrends=" http://goo.gl/teT8AZ\n"+"\n"+Trends;
		String STPatrickHashTags=	"‪#‎Patrick‬ ‪#‎StPatrick‬ ‪#‎StPatrickDay‬ ‪#‎StpatricksDay‬ ‪#‎Festival‬ ‪#‎WorldFestival‬ ‪#‎History‬ ‪#‎Facts‬ ‪#‎fun‬ ‪#‎Celebrations‬ ‪#‎Shamrock‬ ‪#‎Symbol‬ ‪#‎17March‬ ‪#‎March‬ ‪#‎Ireland‬ ‪#‎Green‬ ‪#‎Beer‬ ‪#‎GreenBeer‬\n";
		
		String BrazilCarnival="BRAZILIAN CARNIVAL AND RIO DE JANEIRO CARNIVAL (WORLD’S LARGEST ANNUAL PARTY FESTIVAL OF DANCE AND MUSIC )\n";
		String BrazilCarnivalURLTrends=" http://goo.gl/b4Jl4t\n"+"\n"+Trends;
		String BrazilCarnivalHashTags=" ‪#‎Brazil‬ ‪#‎RioCarnival‬ ‪#‎MusicFestival‬ ‪#‎DanceFestival‬ ‪#‎Party‬ ‪#‎WorldsBiggestFestival‬ ‪#‎Carnival‬ ‪#‎RioDeJanerio‬ ‪#‎Carnaval‬ ‪#‎dance‬ ‪#‎music‬ ‪#‎samba‬ ‪#‎axe‬";


		String TourFrance= "Facts You Didn’t Know About the Tour de France\n";
		String TourFranceURLTrends= " http://goo.gl/5Ui158\n"+"\n"+Trends;
		String TourFranceHashTags= " ‪#‎Facts‬ ‪#‎TourDeFrance‬ ‪#‎France‬ ‪#‎french‬ ‪#‎Festival‬ ‪#‎Race‬ ‪#‎Cycling‬ ‪#‎Amazing‬ ‪#‎Life‬ ‪#‎Enjoy‬ ‪#‎BicycleRace‬ ‪#‎LeTour‬ ‪#‎LaGrandeBoucle‬\n";

		String OktoberFest= "Fun Facts about OktoberFest\n";
		String OktoberFestURLTrends=" http://goo.gl/m5j21K\n"+"\n"+Trends;
		String OktoberFestHashTags=" #OktoberFest #OctoberFest #Beer #Germany  #BeerFestival #Munich #Party #Festival";

		String LikeOurPage= "Like our page";
		String LikeOurPageURLTrends=" https://goo.gl/JPGYCj \n"+" \n This is the place to find the most distinguished and matured posts related to Mobile Phones,Games,Wallpapers,Songs,Fitness,Healthy living, Science, Life."+"\n"+Trends+"";

		//#PostHere
		ArrayList<String> statusline=new ArrayList<>();
		statusline.add(Illuminati);
		statusline.add(IlluminatiSymbols);
		statusline.add(BurningMan);
		statusline.add(STPatrick);
		statusline.add(BrazilCarnival);
		statusline.add(TourFrance);
		statusline.add(LikeOurPage);
		statusline.add(OktoberFest);
		
		
		ArrayList<String> statustrends=new ArrayList<>();
		statustrends.add(IlluminatiURLTrends);
		statustrends.add(IlluminatiSymbolsURLTrends);
		statustrends.add(BurningManURLTrends);
		statustrends.add(STPatrickURLTrends);
		statustrends.add(BrazilCarnivalURLTrends);
		statustrends.add(TourFranceURLTrends);
		statustrends.add(LikeOurPageURLTrends);
		statustrends.add(OktoberFestURLTrends);
		
		ArrayList<String> statushashtags=new ArrayList<>();
		statushashtags.add(IlluminatiHashTags);
		statushashtags.add(IlluminatiSymbolsHashTags);
		statushashtags.add(BurningManHashTags);
		statushashtags.add(STPatrickHashTags);
		statushashtags.add(BrazilCarnivalHashTags);
		statushashtags.add(TourFranceHashTags);
		statushashtags.add(OktoberFestHashTags);
		
		
		for(int i=0;i<statushashtags.size()-1;i++){
			Thread.sleep(7000);
		driver.findElement(By.xpath(".//div[@class='innerWrap']/textarea")).click();
		driver.findElement(By.xpath(".//div[@class='innerWrap']/textarea")).click();
		Thread.sleep(3000);	
		driver.findElement(By.xpath(".//div[@class='innerWrap']/textarea")).sendKeys(statusline.get(i).toString());
		driver.findElement(By.xpath(".//div[@class='innerWrap']/textarea")).sendKeys(statustrends.get(i).toString());
		driver.findElement(By.xpath(".//div[@class='innerWrap']/textarea")).sendKeys(statushashtags.get(i).toString());
		driver.findElement(By.xpath(".//div[@class='innerWrap']/textarea")).sendKeys("Hit Like our page @[0: ]");
		driver.findElement(By.xpath(".//div[@class='innerWrap']/textarea")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(".//div[@class='innerWrap']/textarea")).sendKeys(Keys.ENTER);
		
		Thread.sleep(4000);
		WebElement postbutton=driver.findElement(By.xpath(".//button[starts-with(.,'Post')]"));
		
		for(int n=0;n<5;n++){
			try{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", postbutton);
			System.out.println("In Try Block "+n);
		}
			catch (Exception e){
				System.out.println("In Catch Block "+n);
				continue;
			}
		}
		
		}

	}


}
