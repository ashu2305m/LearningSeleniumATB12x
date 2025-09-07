package org.example.ex14_JS_ShadowDOM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lab_JS_Code_ShadowDOM {
    @Test
    public void test_js() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // ✅ Directly fetch element using querySelector + shadowRoot
        WebElement username = (WebElement) js.executeScript(
                "return document.querySelector('custom-element').shadowRoot.querySelector('#username');");

        // Perform action
        username.sendKeys("Ashutosh");
        driver.quit();

    }
}
/*

HTML STRUCTURE

        <custom-element>
        #shadow-root (open)
    <input id="username" type="text">
  </shadow-root>
</custom-element>

*/

