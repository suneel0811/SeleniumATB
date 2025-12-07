package org.example.pages.PF;

import org.example.base.CommonToAllPage;
import org.example.utils.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends CommonToAllPage {

     WebDriver driver;
    public  LoginPage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "username")
    private WebElement userName;

    @FindBy(xpath = "//input[@placeholder='Enter password']")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement logInBtn;

    @FindBy(id = "js-notification-box-msg")
    private WebElement errorMessage;

    public String logInPageVWO() throws IOException {
        sendKeys(userName, PropertyFileReader.readKey("invalidUsername"));
        sendKeys(password,PropertyFileReader.readKey("invalidPassword"));
       clickElement(logInBtn);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return errorMessage.getText();
    }

}
