package org.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

     public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static void init(){
        if(driver==null){
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--guest");
            driver=new ChromeDriver(options);
        }
    }


    public static void down(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
