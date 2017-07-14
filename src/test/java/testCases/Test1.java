package testCases;

import java.io.IOException;
import java.util.HashMap;

import com.neerajProject.pages.HomePage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.neerajProject.pages.BaseTest;
import com.neerajProject.pages.HomePageLib;
import utilityFiles.ByJQuery;
import utilityFiles.WebDriverOperations;

import static utilityFiles.PropertyReader.getProperties;
import static utilityFiles.XMLReader.getTestDataBasedOnEnviornment;


public class Test1 extends BaseTest {



    //@Title("First Allure Test case")
    //@Test
    public static void function1Test1() throws IOException, InterruptedException {
        //Test data Support
        HashMap<String, String> testDataProduct1 = getTestDataBasedOnEnviornment(getProperties().get("PSA_TESTDATA_FILE"), "Product1", "QA");

        //PropertyReader propertyReader = new PropertyReader();
        //propertyReader.bringObjectProperty();
        //System.out.println(System.getProperty("env"));
        Log.info("Hi logging here");
        Log.error("Hi logging here Error");

        WebDriverOperations webDriverOperations = new WebDriverOperations();
        //webDriverOperations.click();
        /*HomePageLib app=new HomePageLib();
        app.openfacebook();
        */System.out.println(testDataProduct1.get("name"));

        if (System.getProperty("env").equalsIgnoreCase("test")) {
            System.out.println("Property updated and found");
        } else {
            System.out.println("Property not updated or not found");
        }
        driver.get("http://en.wikipedia.org/");
        Assert.assertEquals("One".equals("Two"), true);

    }

    @Test(groups = "my")
    public void function2Test1() {
        System.out.println("In Function2 of test 1 class");
    }

    //@Test
    public void function3Test1() throws InterruptedException {
        System.out.println("In Function3 of test 1 class");
        HomePageLib homePageLib = new HomePageLib();
        Log.info("Hi logging here");
        Log.error("Hi logging here Error");
        homePageLib.openfacebook();
    }

    @Test
    public static void jsoupTestReadHTML() throws InterruptedException, IOException {
        System.out.println("In Jsoup Function");
        HomePageLib app = new HomePageLib();
        Log.info("Hi logging here");
        Log.error("Hi logging here Error");

        WebDriverOperations webDriverOperations = new WebDriverOperations();
        webDriverOperations.get("https://training.adobe.com/training/current-courses.html#p=1&country=India");
        //webDriverOperations.click();
        driver.manage().window().maximize();
        Thread.sleep(9000);
        WebElement element=webDriverOperations.findElementByJQuery("jQuery(\"span:contains('Search Course')\").click()");
        System.out.println("Lets click");

        element.click();
        System.out.println("Clicked");
        /*HomePage homePage=new HomePage(driver);
        homePage.clickFacebookEmail("testidtvt@gmail.com");
        */webDriverOperations.get("http://en.wikipedia.org/");
        System.out.println(webDriverOperations.returnHTML("#mp-itn b a"));

        Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        Elements newsHeadlines = doc.select("#mp-itn b a");

        for (Element e : newsHeadlines) {
            System.out.println("Here is JSOUP HTML" + e.toString());
        }
    }

}
