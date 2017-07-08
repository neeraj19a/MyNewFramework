package com.neeraj.pages;

import java.io.IOException;
import java.util.HashMap;

import com.neeraj.project.App;
import com.neeraj.project.BaseTest;
import com.neeraj.project.WebDriverOperations;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.neeraj.project.PropertyReader;
import ru.yandex.qatools.allure.annotations.Title;

import static com.neeraj.project.PropertyReader.getProperties;
import static com.neeraj.project.XMLReader.getTestDataBasedOnEnviornment;

public class Test1 extends BaseTest {


    @Title("First Allure Test case")
    @Test
    public static void function1Test1() throws IOException {
        //Test data Support
        HashMap<String, String> testDataProduct1 = getTestDataBasedOnEnviornment(getProperties().get("PSA_TESTDATA_FILE"), "Product1", "QA");

        PropertyReader propertyReader = new PropertyReader();
        //propertyReader.bringObjectProperty();
        //System.out.println(System.getProperty("env"));

        System.out.println(testDataProduct1.get("name"));

        if (System.getProperty("env").equalsIgnoreCase("test")) {
            System.out.println("Property updated and found");
        } else {
            System.out.println("Property not updated or not found");
        }
        Assert.assertEquals("One".equals("Two"), true);

    }

    @Test(groups = "my")
    public void function2Test1() {
        System.out.println("In Function2 of test 1 class");
    }

    @Test
    public void function3Test1() {
        System.out.println("In Function3 of test 1 class");
    }

    //@Test

    public static void jsoupTestReadHTML() throws InterruptedException, IOException {
        System.out.println("In Jsoup Function");
        App app = new App();
        //app.opengmail();
        driver.get("http://en.wikipedia.org/");
        WebDriverOperations webDriverOperations = new WebDriverOperations();
        System.out.println(webDriverOperations.returnHTML("#mp-itn b a"));

        Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        Elements newsHeadlines = doc.select("#mp-itn b a");

        for (Element e : newsHeadlines) {
            System.out.println("Here is JSOUP HTML" + e.toString());
        }
    }

}
