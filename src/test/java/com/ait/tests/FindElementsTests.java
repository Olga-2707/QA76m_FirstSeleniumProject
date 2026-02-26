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
    @Test
    public void findElementsById(){
        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getAttribute("id"));

        WebElement dates = driver.findElement(By.id("dates"));
        System.out.println(dates.getAttribute("id"));
    }

    @Test
    public void findElementByClassName(){
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getText());

        WebElement description = driver.findElement(By.className("description"));
        System.out.println(description.getText());
    }

    @Test
    public void findElementByLinkText(){
        WebElement linkText = driver.findElement(By.linkText("Let car work"));
        System.out.println(linkText.getText());
    }

    @Test
    public void findElementByPartialLinkText(){
        WebElement partialLink = driver.findElement(By.partialLinkText("work"));
        System.out.println(partialLink.getText());
    }

    @Test
    public void findElementByCssSelector(){
        //driver.findElement(By.tagName("h1"));
        //tag name 'h1 -> css 'h1'
        driver.findElement(By.cssSelector("h1"));

        //driver.findElement(By.id("city"));
        //id strategy 'city' -> css '#city'
        driver.findElement(By.cssSelector("#city"));

        //driver.findElement(By.className("telephone"));
        //Class 'telephone' -> CSS ".telephone"
        driver.findElement(By.cssSelector(".telephone"));

        //[att='par']
        WebElement element = driver.findElement(By.cssSelector("[href='/search']"));
        System.out.println(element.getText());

        driver.findElement(By.cssSelector("[for='city']"));

        //contains -> * по одному слову внутри названия ссылки
        driver.findElement(By.cssSelector("[href*='car']"));
        //start -> ^
        driver.findElement(By.cssSelector("[href^='/let']"));

        //end to -> $
        driver.findElement(By.cssSelector("[href$='work']"));

        //tag+class+pare(ссылка)
        driver.findElement(By.cssSelector("a.navigation-link[href='/login']"));
        //tag+class
        driver.findElement(By.cssSelector("div.social-networks"));
//one step below
        driver.findElement(By.cssSelector(".logo>img"));
// one or more steps below
        driver.findElement(By.cssSelector(".feedback-card .feedback-date"));
// <tag> or <id> or <class>:nth-child(num);
        WebElement element1 = driver.findElement(By.cssSelector(".search-container:nth-child(1)"));
        System.out.println(element1.getText());
    }

    @Test
    public void findElementByXpath(){
        // some_tag[@key='value']
        // *[@attr='value']
        // some_tag[1]
        // some_tag[text()='Title']

        // driver.findElement(By.cssSelector("h1"));по tag
    driver.findElement(By.xpath("//h1"));

    //driver.findElement(By.cssSelector("#city")); по id
        driver.findElement(By.xpath("//*[@id='city']"));

        // driver.findElement(By.cssSelector(".telephone")); по class
        driver.findElement(By.xpath("//*[@class='telephone']"));

        //driver.findElement(By.cssSelector("[for='city']")); атрибут+параметр
        driver.findElement(By.xpath("//*[@for='city']"));

        //driver.findElement(By.cssSelector("[href^='/let']"));
        //если нужно найти по первому слову напр.в ссылке - start-with()
        driver.findElement(By.xpath("//*[starts-with(@href,'/let')]"));

        //contains text
        //содержит текст - метод contains(text(),'text')
        WebElement text = driver.findElement(By.xpath("//*[contains(text(),'best services')]"));
        System.out.println(text.getText());
//второй вариант поиска текста
//        WebElement text1 = driver.findElement(By.xpath("//*[contains(.,'best services')]"));

        //equals text_ когда по части текста ищем метод text()
        WebElement text2 = driver.findElement(By.xpath("//*[text()='Find your car now!']"));
        System.out.println(text2.getText());

        //equals text альтернатива поиска текста
        WebElement element = driver.findElement(By.xpath("//*[.='Find your car now!']"));
        System.out.println(element.getText());

        //составные tag+class+pair  driver.findElement(By.cssSelector("a.navigation-link[href='/login']"));
        driver.findElement(By.xpath("//a[@class='navigation-link'][@href='/login']"));

        //one step below driver.findElement(By.cssSelector(".logo>img"));
        driver.findElement(By.xpath("//*[@class='logo']/img"));

        // one or more steps below driver.findElement(By.cssSelector(".feedback-card .feedback-date"));
    driver.findElement(By.xpath("//*[@class='feedback-card']//*[@class='feedback-date']"));
//cssSelector -> div>a   xPath -> //div/a
//cssSelector -> div a   xPath-> //div//a

//parent
        driver.findElement(By.xpath("//h1/parent::*"));
        driver.findElement(By.xpath("//h1/parent::div"));//аналогично
        driver.findElement(By.xpath("//h1/.."));// .. движение наверх к родителю
//ancestor
        driver.findElement(By.xpath("//h2/ancestor::*")); //все предки наверх
        driver.findElement(By.xpath("//h2/ancestor::div[2]")); // two steps вверх
        driver.findElement(By.xpath("//h2/ancestor::div")); //выдает все div выше






    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
