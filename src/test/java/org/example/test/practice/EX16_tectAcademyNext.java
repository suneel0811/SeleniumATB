package org.example.test.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class EX16_tectAcademyNext {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        // Optional: disable notifications/pop‑ups
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.get("");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("");

        Thread.sleep(30000);

        for (int i=0;i<300;i++){

            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
// 1. Wait for overlay to disappear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.cssSelector("div.blockUI.blockOverlay")
            ));

            // 2. Wait for Next Lesson button to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[text()='Next Lesson']")
            ));
            driver.findElement(By.xpath("//a[text()='Next Lesson']")).click();
        }
        closeBrowser();
    }

    public static void closeBrowser() {

        driver.quit();

    }
}