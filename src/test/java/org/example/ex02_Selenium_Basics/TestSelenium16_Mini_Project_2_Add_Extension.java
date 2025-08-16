package org.example.ex02_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;

public class TestSelenium16_Mini_Project_2_Add_Extension {

    @Description("Options Class")
    @Test
    public void test_Selenium01() throws Exception {


        ChromeOptions Options = new ChromeOptions();
        Options.addArguments("--window-size=1920,1080"); // Full HD

    //    File path = new File("src/test/java/com/thetestingacademy/ex02_Selenium_Basics/AdBlock.crx");
     //   Options.addExtensions(path);


        WebDriver driver = new ChromeDriver(Options);
        driver.get("https://www.youtube.com/watch?v=BwTSxsAqlEc");
    }
}