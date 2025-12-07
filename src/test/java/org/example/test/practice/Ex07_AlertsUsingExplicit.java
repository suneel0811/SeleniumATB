package org.example.test.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex07_AlertsUsingExplicit {
    static WebDriver driver;
    @Test
    public void testALerts() {

        ChromeOptions options =new ChromeOptions();
        options.addArguments("--guest");
         driver=new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        WebElement title= driver.findElement(By.xpath("//h3[text()='JavaScript Alerts']"));
        System.out.println("Page Title is "+title.getText());
        Assert.assertEquals(title.getText(),"JavaScript Alerts");

        //Alert accept
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
                wait.until(ExpectedConditions.alertIsPresent());

        Alert alert=driver.switchTo().alert();
        alert.accept();


        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[text()='You successfully clicked an alert']")));

        WebElement successMessag=driver.findElement(
                By.xpath("//p[text()='You successfully clicked an alert']"));
        System.out.println(successMessag.getText());

        //alert dismiss
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert2=driver.switchTo().alert();
        alert2.dismiss();

        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(3));

        wait1.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[text()='You clicked: Cancel']")));

        WebElement cancelmessage=driver.findElement(
                By.xpath("//p[text()='You clicked: Cancel']"));
        System.out.println(cancelmessage.getText());

        //alert js prompt - sendKeys

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.alertIsPresent());

        Alert alert1=driver.switchTo().alert();
        alert1.sendKeys("Accepted");
        alert1.accept();

        WebDriverWait wait3=new WebDriverWait(driver,Duration.ofSeconds(3));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[text()='You entered: Accepted']")));

        WebElement jsText=driver.findElement(
                By.xpath("//p[text()='You entered: Accepted']"));
        System.out.println(jsText.getText());
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
