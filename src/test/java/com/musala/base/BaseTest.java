package com.musala.base;

import com.musala.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected ThreadLocal<WebDriver>  driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver) {
    this.driver.set(driver);
     }

     public WebDriver getDriver(){
        return this.driver.get();
     }

    @BeforeMethod
    public void setup(){
        WebDriver driver = new DriverFactory().initializeDriver();
        setDriver(driver);
     }
    @AfterMethod
    public void teardown(){
        getDriver().quit();
    }
}
