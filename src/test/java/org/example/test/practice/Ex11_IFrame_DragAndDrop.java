package org.example.test.practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Ex11_IFrame_DragAndDrop {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        // Optional: disable notifications/pop‑ups
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/#google_vignette");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        Actions actions=new Actions(driver);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        actions.sendKeys(Keys.PAGE_UP).perform();

        //moving first frame i frame
        driver.switchTo().frame(0);   // OR use frame locator

        WebElement from = driver.findElement(By.xpath("//h5[text()='High Tatras']/following::img[1]"));
        WebElement to = driver.findElement(By.xpath("//div[@id='trash']"));

        //actions.dragAndDrop(from,to).build().perform();

        actions.clickAndHold(from).moveToElement(to).release(to).build().perform();

        Thread.sleep(3000);
        closeBrowser();


    }

    public static void closeBrowser() {

        driver.quit();
    }
    }
