package org.example.test.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ex05_WaitHelperGeneric {

    public static void checkVisibilityExplicit(WebDriver driver, By locator, int time){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void checkVisibilityFluentWait(ChromeDriver driver,By locator,int totalTime,int pollingTime ){

        //Wait<WebDriver> wait=new FluentWait<>(driver) -->//In parameter also we need to use WebDriver driver
            //insted of ChromeDriver driver

        Wait<ChromeDriver> wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(totalTime))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
