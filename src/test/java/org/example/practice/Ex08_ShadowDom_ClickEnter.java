package org.example.practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ex08_ShadowDom_ClickEnter {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        driver  = new ChromeDriver(options);
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();

        JavascriptExecutor js= (JavascriptExecutor) driver;

        //we will scroll to till header shadow so we can send desired data
        WebElement divScrollTo=driver.findElement(By.xpath("//div[@id='userName']"));
        js.executeScript("arguments[0].scrollIntoView(true)",divScrollTo);

        Thread.sleep(3000);

        WebElement pizzaInputBox= (WebElement) js.executeScript("return document.querySelector(\"div#userName\")" +
                ".shadowRoot.querySelector(\"div\")" +
                ".shadowRoot.querySelector(\"input#pizza\")");
        pizzaInputBox.sendKeys("SpicyChicken");

        WebElement nameInputBox= (WebElement) js.executeScript("return document.querySelector(\"div#userName\")" +
                ".shadowRoot.querySelector(\"input#kils\")");
        nameInputBox.sendKeys("suneel");
                Thread.sleep(3000);

        closeBrowser();
    }
    public static void  closeBrowser(){

        driver.quit();
    }
}
