package com.musala.pages;

import com.musala.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Set;

public class CompanyPage extends BasePage {
    public CompanyPage(WebDriver driver) {
        //Constructor
        super(driver);
    }

    //The Elements
    @FindBy(css = ".title")
     WebElement companyPageTitle ;
    @FindBy(css = "#content > div.entry-header > div > div.image-overlay > div > h1")
    private WebElement companyHeader;
    @FindBy(css = "[href='https://www.facebook.com/MusalaSoft?fref=ts']")
    private WebElement facebookIcon;
    @FindBy(css = "[preserveAspectRatio='xMidYMid slice']")
    private WebElement musalaFBProfilePic;



    //The Methods

    @Step("Verify that the Leadership section is displayed inside Current Page")
    public boolean isThisSectionDisplayed(String searchWord) {
        visibilityOfElement(driver,companyHeader);
        return driver.getPageSource().contains(searchWord);
    }
    @Step("Click on Facebook icon from footer to open Facebook page")
    public CompanyPage clickOnFaceBookIcon() {
        waitElementToClickable(driver,facebookIcon);
        visibilityOfElement(driver,facebookIcon);
        BasePage.footerElements(3);
        BasePage.switchWindow();
        return new CompanyPage(driver);
    }

    @Step("Move to the New Tab")
    public CompanyPage moveToOtherTab() throws InterruptedException
    {
        String cHandle = driver.getWindowHandle();
        String newWindowHandle = null;
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (int i1 = 0; i1 < 20; i1++) {
            if (allWindowHandles.size() > 1) {
                for (String allHandlers : allWindowHandles) {
                    if (!allHandlers.equals(cHandle))
                        newWindowHandle = allHandlers;
                }
                driver.switchTo().window(newWindowHandle);
                break;
            }
        }
        if (cHandle == newWindowHandle) {
            throw new RuntimeException("Time out - No window found");
        }
        return new CompanyPage(driver);
    }
    @Step("Get the Current Page URL")
    public static String getURL() {
        return driver.getCurrentUrl();
    }
    @Step("Verify that this is Musala’s Profile Pic is displayed in Facebook Page ")
    public boolean isMusalaProfilePicDsplayed() {
        visibilityOfElement(driver,musalaFBProfilePic);
        hoverOnTheElement(musalaFBProfilePic);
        return musalaFBProfilePic.isDisplayed();
    }
}
