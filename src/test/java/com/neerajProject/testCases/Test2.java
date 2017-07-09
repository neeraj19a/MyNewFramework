package com.neerajProject.testCases;

import utilityFiles.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Test2 extends BaseTest {


    public Test2(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public static void function1Test1() {
        System.out.println("In Function1 of test 2 class");
        driver.get("https://hello.is/about");
    }

}
