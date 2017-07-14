package testCases;

import com.neerajProject.pages.HomePage;
import com.neerajProject.pages.HomePageLib;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.neerajProject.pages.BaseTest;
import utilityFiles.WebDriverOperations;

import java.io.IOException;

public class Test2 extends BaseTest {


    public Test2(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public static void function1Test1() {
        System.out.println("In Function1 of test 2 class");
        driver.get("https://hello.is/about");
    }

    @Test
    public static void jsoupTestReadHTML() throws InterruptedException, IOException {
        System.out.println("In Jsoup Function Class 2");
        HomePageLib app = new HomePageLib();
        Log.info("Hi logging here");
        Log.error("Hi logging here Error");

        WebDriverOperations webDriverOperations = new WebDriverOperations();
        webDriverOperations.get("https://training.adobe.com/training/current-courses.html#p=1&country=India");

        //webDriverOperations.click();
        driver.manage().window().maximize();
        Thread.sleep(9000);
        //JQuery Support
        WebElement element=webDriverOperations.findElementByJQuery("jQuery(\"span:contains('Search Course')\").click()");
        System.out.println("Lets click");

        element.click();
        System.out.println("Clicked");
        HomePage homePage=new HomePage(driver);
        webDriverOperations.get("https://www.facebook.com/");
        homePage.clickFacebookEmail("testidtvt@gmail.com");
        webDriverOperations.get("http://en.wikipedia.org/");
        System.out.println(webDriverOperations.returnHTML("#mp-itn b a"));

        Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        Elements newsHeadlines = doc.select("#mp-itn b a");

        for (Element e : newsHeadlines) {
            System.out.println("Here is JSOUP HTML" + e.toString());
        }
    }

}
