package org.example.test.practice;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ex02_ChromeOptionsAndProxy {
    public static void main(String[] args) {

        //ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--guest");

        //Proxy
        Proxy proxy=new Proxy();
        proxy.setHttpProxy("12.40.185.42:1080");
        options.setCapability("proxy",proxy);


        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://app.vwo.com/#/login");
        driver.quit();
    }
}
