package org.example.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class Ex13_SwitchWindow {


    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        // Optional: disable notifications/pop‑ups
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        String originalWindow=driver.getWindowHandle();

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandles=driver.getWindowHandles();
        for (String handle: windowHandles) {
            System.out.println(handle);
            driver.switchTo().window(handle);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("New tab opened");
            }else{
                System.out.println("not opened");
            }
        }

        driver.switchTo().window(originalWindow);
        if((driver).getPageSource().contains("Opening a new window")){
            System.out.println("Page is in original tab");
        }else{
            System.out.println("Page is new tab");
        }
        Thread.sleep(3000);
        closeBrowser();
    }

    public static void closeBrowser() {

        driver.quit();

}
    }
