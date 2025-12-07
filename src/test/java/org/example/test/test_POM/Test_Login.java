package org.example.test.test_POM;

import org.example.pages.POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Login {
    @Test
    public void testLoginNegative() throws InterruptedException {
        //POM package
        LoginPage loginPage = new LoginPage();
        String errorMessage = loginPage.logInPageVWO();

        Assert.assertEquals(errorMessage, "Your email, password, IP " +
                "address or location did not match");
    }
}
