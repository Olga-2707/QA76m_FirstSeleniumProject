package hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FirstHW {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().fullscreen();

    }

    @Test
    public void findElementByTagName() {
        WebElement h2 = driver.findElement(By.tagName("h2"));
        System.out.println(h2.getText());

        WebElement ul = driver.findElement(By.tagName("ul"));
        System.out.println(ul.getText());

        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());

        List<WebElement> elements1 = driver.findElements(By.tagName("li"));
        System.out.println(elements1.size());

        WebElement span = driver.findElement(By.tagName("span"));
        System.out.println(span.getText());

        WebElement label = driver.findElement(By.tagName("label"));
        System.out.println(label.getText());

        List<WebElement> strongs = driver.findElements(By.tagName("strong"));
        System.out.println(strongs.size());

        WebElement input = driver.findElement(By.tagName("input"));
        System.out.println(input.getText());

        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println(images.size());

        WebElement script = driver.findElement(By.tagName("script"));
        System.out.println(script.getText());

    }

    @AfterMethod (enabled = false)
    public void tearDown(){
        driver.quit();
    }

}
