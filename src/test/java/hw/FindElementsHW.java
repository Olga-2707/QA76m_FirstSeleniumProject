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

    @Test
    public void findElementXPath(){
        driver.findElement(By.xpath("//h2"));

        driver.findElement(By.xpath("//*[@id='bar-notification']"));

        driver.findElement(By.xpath("//div[@class='details']"));

        driver.findElement(By.xpath("//div[@class='product-item']"));

        driver.findElement(By.xpath("//*[contains(@title,'Show details')]"));

        driver.findElement(By.xpath("//style[@type='text/css'][@xpath='1']"));

        driver.findElement(By.xpath("//*[contains(@href, 'cheap-own-computer')]"));

        driver.findElement(By.xpath("//input[@type='button'][@value='Vote']"));

        driver.findElement(By.xpath("//div/a[@href='/']"));

        driver.findElement(By.xpath("//a[@href='/digital-downloads'][@xpath='1']"));
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }
}
