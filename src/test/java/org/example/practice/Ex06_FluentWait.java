package org.example.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.example.practice.Ex05_WaitHelperGeneric.checkVisibilityFluentWait;

public class Ex06_FluentWait {
    ChromeDriver driver;
    @BeforeTest
    public void launchBrowser(){

        ChromeOptions options =new ChromeOptions();
        options.addArguments("--guest");
        driver=new ChromeDriver(options);
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
    }

    @Test
    public void logInToVWO() throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Enter password']"))
                .sendKeys("Passsword");
        driver.findElement(By.id("js-login-btn")).click();

        WebElement errorMessage= driver.findElement(By.id("js-notification-box-msg"));

        //Fluent wait
        Wait<ChromeDriver> wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.textToBePresentInElement(errorMessage,"Your email, password, IP " +
                "address or location did not match"));


        //Thread.sleep(5000);

        Assert.assertEquals(errorMessage.getText(),"Your email, password, IP address or " +
                "location did not match");

        // visibilityOfElementLocated using FluentWait
        checkVisibilityFluentWait(driver,By.id("js-sign-in-heading"),10,2);

    }
    @AfterTest
    public void browserClose(){
        driver.quit();
    }
}
