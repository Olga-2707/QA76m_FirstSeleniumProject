package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementInTable {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void findCssElementInTable() {
// get number of rows
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        System.out.println(rows.size());

        for (int i = 0; i < rows.size(); i++) {
            System.out.println(rows.get(i).getText());
            System.out.println("**************");
        }
        for (WebElement element : rows) {
            System.out.println(element.getText());
            System.out.println("******************");
        }
//        //get row 4
        WebElement mexico = driver.findElement(By.cssSelector("#customers tr:nth-child(4)"));
        System.out.println(mexico.getText());
        System.out.println("***************");
        //get row 4, last element
//        WebElement country = driver.findElement(By.cssSelector("#customers tr:nth-child(5) td:nth-child(3)"));
        WebElement country = driver.findElement(By.cssSelector("#customers tr:nth-child(5) td:last-child"));
        System.out.println(country.getText());
        System.out.println("*************");
    }

    @Test
    public void tableXpath() {
        List<WebElement> rows = driver.findElements(By.xpath("//tr"));
        System.out.println(rows.size());

        WebElement mexico = driver.findElement(By.xpath("//*[@id='customers']//tr[4]"));
        System.out.println(mexico.getText());

        driver.findElement(By.xpath("//*[@id='customers']//tr[4]//td[last()]"));
    }


    @AfterMethod(enabled = false)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

