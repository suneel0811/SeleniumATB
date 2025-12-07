package org.example.test.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Ex12_FileUpload {


    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        // Optional: disable notifications/pop‑ups
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.get("https://practice.expandtesting.com/upload");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);
        String downloadsPath = System.getProperty("user.home") + File.separator + "Downloads";
        System.out.println(downloadsPath);

        WebElement fileupload=driver.findElement(By.id("fileInput"));

        fileupload.sendKeys(downloadsPath+"/Capture.PNG");
        Thread.sleep(2000);
        driver.findElement(By.id("fileSubmit")).click();

        WebElement uploadedMsg=driver.findElement(By.xpath("//h1[text()='File Uploaded!']"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until((ExpectedConditions.visibilityOf(uploadedMsg)));

        System.out.println(uploadedMsg.getText());
        Thread.sleep(3000);
        closeBrowser();
    }

    public static void closeBrowser() {

        driver.quit();
    }
}