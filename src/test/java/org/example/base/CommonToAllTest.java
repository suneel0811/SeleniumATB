package org.example.base;

import org.example.driver.DriverManagerTL;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class CommonToAllTest {

    //To call start the webDriver
    //Start WebDriver
    //Down WebDriver

    @BeforeMethod
    public void setUp() {
        DriverManagerTL.init();
    }

    @AfterMethod
    public void tearDown() {
        DriverManagerTL.down();
    }
}
