package org.example.test.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Ex10_MouseHover_Click {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        // Optional: disable notifications/pop‑ups
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.get("https://practice.expandtesting.com/hovers");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        WebElement user1=driver.findElement(By.xpath("//img[@data-testid='img-user-1']"));

        Actions actions=new Actions(driver);
        actions.moveToElement(user1).build().perform();

        WebElement visibleUser= driver.findElement(By.xpath("//h5[text()='name: user1']"));

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(visibleUser));

        Assert.assertEquals(visibleUser.getText(),"name: user1");

        System.out.println(visibleUser.getText());
        List<WebElement> profiles= driver.findElements(By.xpath("//a[text()='View profile']"));

        actions.moveToElement(profiles.get(0)).click().build().perform();
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());

        closeBrowser();


    }

    public static void closeBrowser() {

        driver.quit();
    }
}

