package com.neeraj.project;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import ru.yandex.qatools.allure.annotations.Attachment;

public class BaseTest {

    public static WebDriver driver = new FirefoxDriver();
    public static WebDriverOperations wops = new WebDriverOperations();

    @Attachment
    public byte[] screenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterMethod(groups = "horizontal", alwaysRun = true)
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                // screenshooting            screenShot();
            }

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
