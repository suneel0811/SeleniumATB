package org.example.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.WebDriverListener;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Ex14_RelativeLocators {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        // Optional: disable notifications/pop‑ups
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        WebElement yearsOfExp=driver.findElement(By.xpath("//span[text()='Years of Experience']"));
        driver.findElement(with(By.id("exp-0")).toRightOf(yearsOfExp)).click();

        Thread.sleep(2000);
        WebElement profession =driver.findElement(By.id("profession-1"));
        WebElement check =driver.findElement(with(By.id("profession-0")).toLeftOf(profession));
        System.out.println(check);

        Thread.sleep(3000);
        closeBrowser();
    }

    public static void closeBrowser() {

        driver.quit();

    }
}
