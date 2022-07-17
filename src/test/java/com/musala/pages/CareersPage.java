package com.musala.pages;

import com.musala.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class CareersPage extends BasePage {
    public CareersPage(WebDriver driver) {

        //Constructor
        super(driver);
    }

    //The Elements
    @FindBy(css = "[data-alt='Check our open positions']")
    WebElement checkOpenPositionsButton;
    @FindBys({
            @FindBy(className = "front"),
            @FindBy(tagName = "h2")})
    public List<WebElement> cards;
    @FindBys({
            @FindBy(className = "card-container"),
            @FindBy(tagName = "a")})
    public List<WebElement> cardsLinks;
    //@FindBy(css = "[class='card-jobsHot__title']")
    //WebElement cardTitle;

    @FindBy(css = ".btn-apply")
    WebElement applyButton;


    //The Methods
    @Step(" Click on Check our open positions button")
    public CareersPage clickOnPositionsButton() {
        checkOpenPositionsButton.click();
        return new CareersPage(driver);
    }
    @Step("Verify that the Join Us page is opened")
    public String getUrl() {
        return driver.getCurrentUrl();
    }
    @Step("Filter the available positions by available cities in the dropdown Select location  ")
    public CareersPage selectLocationBy(String cityName) {
        Select jobsLocations = new Select(driver.findElement(By.id("get_location")));
        jobsLocations.selectByVisibleText(cityName);
        return new CareersPage(driver);
    }
    @Step("Choose an open position by name")
    public CareersPage choosePosition(String Position) {
        for (int i = 0; i < cards.size(); i = i + 1) {
            if (Position.equals(cards.get(i).getText())) {
                cards.get(i).click();
                break;
            }
        }
        return new CareersPage(driver);
    }
    @Step("Scroll down ")
    public CareersPage scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return new CareersPage(driver);
    }
    @Step("Scroll Down ")
    public CareersPage scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");
        return new CareersPage(driver);
    }
    @Step("Verify that 4 main sections are shown: General Description, Requirements, Responsibilities, What we offer")
    public boolean verifyMainSectionsDisplayed() {
        if (driver.getPageSource().contains("General description")
            && driver.getPageSource().contains("Requirements")
            && driver.getPageSource().contains("Responsibilities")
            && driver.getPageSource().contains("What we offer")) {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Step("Verify that Apply button is presented at the bottom ")
        public boolean isApplyButtonPresented () {
        return applyButton.isDisplayed();
        }

    @Step("Click on Apply button")
        public void clickOnApplyButton () {
        clickByJavascript(applyButton);
        }

    @Step("Print in the console the list with available positions by city")
    public CareersPage printAvailablePositionsInConsole (String currentCity){
        System.out.println(currentCity);
        for (int i = 0; i < cards.size(); i = i + 1) {
            System.out.println("Position :  " + cards.get(i).getText());
            for (int y = 0; y < cardsLinks.size(); y = y + 1) {
                System.out.println("More info: " + cardsLinks.get(i).getAttribute("href"));
                break;
            }
        }
        System.out.println("--------------------------------------");
        return new CareersPage(driver);
    }
    }

