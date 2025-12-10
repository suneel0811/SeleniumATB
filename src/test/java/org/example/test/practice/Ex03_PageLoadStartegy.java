package org.example.test.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ex03_PageLoadStartegy {
    public static void main(String[] args) {

        ChromeOptions options=new ChromeOptions() ;
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setPageLoadStrategy(PageLoadStrategy.NONE);

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");

        WebElement username=driver.findElement(By.id("login-username"));

        username.sendKeys("Suneel");
        driver.quit();

    }
}
