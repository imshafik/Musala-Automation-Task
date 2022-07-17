package com.musala.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

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

    public void waitElementToClickable(WebDriver driver , WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void visibilityOfElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void hoverOnTheElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public static void switchWindow(){
        String currentwindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        java.util.Iterator<String> itr = allWindows.iterator();
        while(itr.hasNext()){
            String childwindow = itr.next();
            if(!childwindow.equalsIgnoreCase(currentwindow)){
                driver.switchTo().window(childwindow);
            }
        }
    }


    public static void  footerElements(int j) {
        By FooterLinks = By.xpath("//div[@class='links-buttons']");
        WebElement footer = driver.findElement(FooterLinks);
        List<WebElement> footlinks=footer.findElements(By.tagName("a"));
        WebElement elementName = footlinks.get(j);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(elementName));

        Actions action = new Actions(driver);
        action.moveToElement(elementName).click(elementName).perform();
    }

}
