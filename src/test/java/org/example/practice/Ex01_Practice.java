package org.example.practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Ex01_Practice {
    public static void main(String[] args) {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");

        ChromeDriver driver=new ChromeDriver(options);
        driver.get("https://app.vwo.com/#/login");

        driver.navigate().to("https://sdet.club/login?redirectTo=%2F");
        driver.navigate().back();
        driver.manage().window().maximize();
        driver.navigate().forward();
        driver.navigate().refresh();
        Assert.assertEquals(driver.getTitle(),"Welcome back!");
        Assert.assertEquals(driver.getCurrentUrl(),"https://sdet.club/login?redirectTo=%2F");
        driver.quit();

    }
}
