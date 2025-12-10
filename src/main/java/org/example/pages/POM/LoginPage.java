package org.example.pages.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.base.CommonToAllPage;

public class LoginPage extends CommonToAllPage{

    public LoginPage() {   // constructor required
        super();           // ensures CommonToAllPage can access driver
    }

    private By userName = By.name("username");
    private By password = By.xpath("//input[@placeholder='Enter password']");
    private By logInBtn = By.id("js-login-btn");
    private By errorMessage = By.id("js-notification-box-msg");

    public String logInPageVWO() throws InterruptedException {
        sendKeys(userName, "Suneel@gmail.com");
        sendKeys(password, "password");
        clickElement(logInBtn);

        WebElement msg = visibilityOfElement(errorMessage);
        return msg.getText();

    }


}
