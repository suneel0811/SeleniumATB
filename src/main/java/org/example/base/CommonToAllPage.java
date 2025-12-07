package org.example.base;

import org.example.utils.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static org.example.driver.DriverManager.getDriver;

public class CommonToAllPage {

    public void launchUrl() throws IOException {
        getDriver().get(PropertyFileReader.readKey("URL"));

    }
    //              ***********************************************
    //For POM
    public void clickElement(By by){
        getDriver().findElement(by).click();
    }

    public void sendKeys(By by,String key){
        getDriver().findElement(by).sendKeys(key);
    }
    public WebElement getElement(By by){
        return getDriver().findElement(by);
    }

    //              ***********************************************
    //For PF
    public void clickElement(WebElement element){
        element.click();
    }

    public void sendKeys(WebElement element,String key){
        element.sendKeys(key);
    }

    public WebElement getElement(WebElement element){
       return element;
    }

    //              ***********************************************
    public WebElement presenceOfElement(By elementLocation){
        return new WebDriverWait(getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }
    public WebElement visibilityOfElement(By elementLocation){
        return new WebDriverWait(getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }


}
