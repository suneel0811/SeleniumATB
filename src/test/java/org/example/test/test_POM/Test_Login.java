package org.example.test.test_POM;

import org.example.base.CommonToAllTest;
import org.example.pages.POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Login extends CommonToAllTest {
    @Test
    public void testLoginNegative() throws InterruptedException, IOException {
        //POM package
        LoginPage loginPage = new LoginPage();
        loginPage.launchUrl();
        String errorMessage = loginPage.logInPageVWO();

        Assert.assertEquals(errorMessage, "Your email, password, IP " +
                "address or location did not match");
    }

    @Test
    public void testLoginNegative2() throws InterruptedException, IOException {
        //POM package
        LoginPage loginPage = new LoginPage();
        loginPage.launchUrl();
        String errorMessage = loginPage.logInPageVWO();

        Assert.assertEquals(errorMessage, "Your email, password, IP " +
                "address or location did not match");
    }
}
