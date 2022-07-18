package com.musala.pages;

import com.musala.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CompanyPage extends BasePage {
    public CompanyPage(WebDriver driver) {
        //Constructor
        super(driver);
    }

    //The Elements
    @FindBy(css = ".title")
    private WebElement companyPageTitle ;
    @FindBy(css = "[href='https://www.facebook.com/MusalaSoft?fref=ts']")
    private WebElement facebookIcon;
    @FindBy(css = "[preserveAspectRatio='xMidYMid slice']")
    private WebElement musalaFBProfilePic;



    //The Methods

    @Step("Scroll down ")
    public CareersPage scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        return new CareersPage(driver);
    }

    @Step("Verify that the Leadership section is displayed inside Current Page")
    public boolean isThisSectionDisplayed(String searchWord) {
        return driver.getPageSource().contains(searchWord);
    }

    @Step("Click on Facebook icon from footer to open Facebook page")
    public CompanyPage clickOnFaceBookIcon() throws InterruptedException {
        waitElementToClickable(driver,facebookIcon);
        facebookIcon.click();
        Thread.sleep(3000);
        switchWindow();
    return new CompanyPage(driver);
    }

    @Step("Get the current Page URL")
    public static String getURL() {
        return driver.getCurrentUrl();
    }
    @Step("Verify that this is Musala’s Profile Pic is displayed in Facebook Page ")
    public boolean isMusalaProfilePicDsplayed() {
        hoverOnTheElement(musalaFBProfilePic);
        return musalaFBProfilePic.isDisplayed();
    }
}
