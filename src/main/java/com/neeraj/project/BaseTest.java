package com.neeraj.project;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.yandex.qatools.allure.annotations.Attachment;
import java.io.File;

public class BaseTest {

    public static WebDriver driver;
    //public static WebDriverOperations wops = new WebDriverOperations();


    @Attachment
    public byte[] screenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @BeforeMethod
    public void setup(){
        if(System.getProperty("browser").equalsIgnoreCase("Firefox")) {
            System.out.println("Opening Firefox Browser");
            driver = new FirefoxDriver();
        }
        else
        {
            File chromeDriver = new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
            System.out.println("Opening Chrome Browser");
            System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath() );
            driver = new ChromeDriver();
        }

    }

    @AfterMethod(groups = "horizontal", alwaysRun = true)
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                //screenshooting
                screenShot();
            }
            System.out.println("Closing Browser");

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
