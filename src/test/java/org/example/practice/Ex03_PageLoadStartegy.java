package org.example.practice;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ex03_PageLoadStartegy {
    public static void main(String[] args) {

        ChromeOptions options=new ChromeOptions() ;
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setPageLoadStrategy(PageLoadStrategy.NONE);

        ChromeDriver driver=new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.navigate().to();

    }
}
