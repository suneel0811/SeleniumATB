package org.example.test.test_PF;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.example.base.CommonToAllTest;
import org.example.pages.PF.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.example.driver.DriverManagerTL.getDriver;


public class Test_Login extends CommonToAllTest {
    private static final Logger log = LogManager.getLogger(Test_Login.class);
    @Test
    public void testLoginNegative() throws InterruptedException, IOException {


        //PF package
        log.info("Starting testing");
        LoginPage loginPage = new LoginPage();
        loginPage.launchUrl();
        String errorMessage = loginPage.logInPageVWO();
        log.info("testcase validation");
        Assert.assertEquals(errorMessage, "Your email, password, IP " +
                "address or location did not match");

        //AssetJ
        Assertions.assertThat(errorMessage).isNotNull().isNotBlank();
    }
}
