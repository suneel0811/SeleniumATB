package org.example.test.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Ex09_Actions_buildClick {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        // Optional: disable notifications/pop‑ups
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();


        WebElement oneWayFrom=driver.findElement(By
                .xpath("//div[@data-testid='to-testID-origin']/descendant::input"));

        oneWayFrom.click();
        Thread.sleep(2000);
        WebElement state=driver.findElement(By
                .xpath("//div[contains(@class,'r-ql8eny')]//div[1]/descendant::div[1]/descendant::div[2]"));
        System.out.println("State is "+state.getText());


        Actions actions=new Actions(driver);
        actions.moveToElement(oneWayFrom).click().sendKeys("BLR").perform();
        Thread.sleep(3000);
        closeBrowser();
    }

    public static void closeBrowser() {

        driver.quit();
    }
}
