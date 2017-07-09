package com.neerajProject.pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BaseTest implements IHookable {

    String methodName = "";
    public static WebDriver driver;
    public static final org.apache.log4j.Logger Log = Logger.getLogger(BaseTest.class);
    //public static WebDriverOperations wops = new WebDriverOperations();
    public BaseTest(){

    /*    org.apache.log4j.BasicConfigurator.configure();
        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\log4j.properties");
    */}

    @BeforeMethod
    public void setup() {
        if (System.getProperty("browser").equalsIgnoreCase("Firefox")) {
            System.out.println("Opening Firefox Browser");
            driver = new FirefoxDriver();
        } else {
            File chromeDriver = new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
            System.out.println("Opening Chrome Browser");
            System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
            driver = new ChromeDriver();
        }
        org.apache.log4j.BasicConfigurator.configure();
        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\log4j.properties");

    }

    @AfterMethod(groups = "horizontal", alwaysRun = true)
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
            }
            System.out.println("Closing Browser");
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {

        callBack.runTestMethod(testResult);
        if (testResult.getThrowable() != null) {
            try {
                methodName = testResult.getMethod().getMethodName();
                takeScreenShot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Attachment(value = "Failure in method", type = "image/png")
    private byte[] takeScreenShot() throws IOException {
        System.out.println("==========Found failure in method---->  " + methodName + "  <----- Taking screenshot============");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
