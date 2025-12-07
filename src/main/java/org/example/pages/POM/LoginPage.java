package org.example.pages.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    public void logInPage_POM() {

    }

    private By userName = By.name("username");
    private By password = By.xpath("//input[@placeholder='Enter password']");
    private By logInBtn = By.id("js-login-btn");
    private By errorMessage = By.id("js-notification-box-msg");

    public String logInPageVWO() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");
        driver.findElement(userName).sendKeys("Suneel@gmail.com");
        driver.findElement(password).sendKeys("password");


        driver.findElement(logInBtn).click();
        Thread.sleep(3000);
        WebElement error_msg = driver.findElement(errorMessage);
        String errorMsg = error_msg.getText();
        return errorMsg;

    }


}
