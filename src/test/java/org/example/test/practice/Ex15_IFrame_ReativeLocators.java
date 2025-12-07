package org.example.test.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Ex15_IFrame_ReativeLocators {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        // Optional: disable notifications/pop‑ups
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //I frame
        driver.switchTo().frame("result");

        //click on submit button
        WebElement submit=driver.findElement(By.xpath("//button[text()='Submit']"));
        submit.click();

        WebElement username=driver.findElement(By.id("username"));
       WebElement errorMessage= driver.findElement(with(By.tagName("small")).below(username));
        System.out.println(errorMessage.getText());

        Assert.assertEquals(errorMessage.getText(),"Username must be at least 3 characters");
        Thread.sleep(3000);
        closeBrowser();
    }

    public static void closeBrowser() {

        driver.quit();
    }
}