package org.example.ex9_DynamicWebtables;

import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lab_Ex_webtable2 {


    WebDriver driver = new ChromeDriver();

    @Owner("Ashutosh")
    @Test
    public void testBrowser() throws InterruptedException {
        // Who is in Google
        driver.get("https://awesomeqa.com/webtable.html");

        // How to Fetch To Table?
        // Xpath => //table[@id='customers'], CSS Selector, ID
        // If something is Dynamic in nature -> //table[contains(@id,"cust")]
        // ByTagName -> table - 1 table only

        // Row , Col
        // Number of Rows and Column in table
        int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th")).size();
        //  int col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/td")).size();
        System.out.println(row);
        System.out.println(col);

        // //table[@id='customers']/tbody/tr[i]/td[j]


        String first_part = "//table[@id='customers']/tbody/tr";
        String second_part = "/td[";
        String third_part = "]";

        for (int i = 2; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                String dynamic_path = first_part + i + second_part + j + third_part;
                // System.out.println(dynamic_path);
                String data = driver.findElement(By.xpath(dynamic_path)).getText();
                System.out.print(data + " ");

                while (data.contains("Helen Bennett")) {
                    driver.findElement(By.xpath("next")).click();
                    if (data.contains("Helen Bennett")) {
                        String country_path = dynamic_path + "/following-sibling::td";
                        String country_text = driver.findElement(By.xpath(country_path)).getText();
                        System.out.println("------");
                        System.out.println("Helen Bennett is In - " + country_text);
                    }
                }
            }
        }
    }
}
