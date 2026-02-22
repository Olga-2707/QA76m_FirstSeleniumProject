package com.ait.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver;

    //before test
    @BeforeMethod  //анотация для выполнения
    public void setUp(){
       driver = new ChromeDriver();
       driver.get("https://www.google.com"); //без истории браузера
//        driver.navigate().to("https://www.google.com"); //аналог метода get, но с историей браузера
       driver.navigate().back(); //возвращает назад в браузере
       driver.navigate().forward(); //переведет на страницу вперед
       driver.navigate().refresh(); //обновляет страницу в браузере

    }

//test
    @Test
    public void openBrowser(){
        System.out.println("Open Google"); //комментарий в консоли

    }


//after test
    @AfterMethod(enabled = false) // если true будет закрывать браузер
    public void tearDown(){
        driver.quit(); //закрывает все вкладки и браузер
//        driver.close(); //закрывает только последнюю вкладку/ если одна вкладка -> браузер закроет
    }

}


