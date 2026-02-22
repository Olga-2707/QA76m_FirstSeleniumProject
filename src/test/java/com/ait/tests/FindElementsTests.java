package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10");

       driver.manage().window().maximize(); //разворачивает страницу в браузере на полный экран
//         driver.manage().window().fullscreen(); //разворачивает на полный экран как F11
//        driver.manage().window().setSize(new Dimension(900, 400));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //таймер в 10 сек на загрузку элементов
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

    }
    @Test
    public void findElementByTagNameTest(){
        //поиск по tag - h1

        WebElement title = driver.findElement(By.tagName("h1"));  //Alt+Enter => создание локальной переменной
        System.out.println(title.getText());
        // find element h2
        WebElement title2 = driver.findElement(By.tagName("h2"));
        System.out.println(title2.getText());
        //find by tag - a
        WebElement link = driver.findElement(By.tagName("a"));
        System.out.println(link.getText());

        //find by tag - label
        WebElement label = driver.findElement(By.tagName("label"));
        System.out.println(label.getText());

        List<WebElement> labels = driver.findElements(By.tagName("label"));
        System.out.println(labels.size());

        //find list of elements
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }
}
