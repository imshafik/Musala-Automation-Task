package com.musala.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void clickByJavascript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", element);
    }

    public void waitElementToClickable(WebDriver driver , int time , WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }
    public  static void waitForVisibility(WebDriver driver , int time , By element) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }
    public static void visibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
       // wait.until(ExpectedConditions.presenceOfElementLocated(element));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void hoverOnTheElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

}
