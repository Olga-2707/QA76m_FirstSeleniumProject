package hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FindElementsHW {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementsCssSelector(){
        driver.findElement(By.cssSelector("#dialog-notifications-success"));

        driver.findElement(By.cssSelector(".header-logo"));

        driver.findElement(By.cssSelector("[type='text/javascript']"));

        driver.findElement(By.cssSelector("[href='/jewelry']"));

        driver.findElement(By.cssSelector("[href^='/gift']"));

        driver.findElement(By.cssSelector("[href$='/camera-photo']"));

        driver.findElement(By.cssSelector("[href*='academy']"));

        driver.findElement(By.cssSelector("a.nivo-imageLink[href='https://academy.tricentis.com']"));

        driver.findElement(By.cssSelector(".center-3 .nivoSlider"));

        driver.findElement(By.cssSelector(".poll-options:nth-child(2)"));
        //что находит?
    }


    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }
}
