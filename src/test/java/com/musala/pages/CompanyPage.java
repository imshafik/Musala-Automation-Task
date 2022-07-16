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
    @FindBy(css = "[href='https://www.facebook.com/MusalaSoft?fref=ts']")
    private WebElement facebookIcon;
    @FindBy(css = "[preserveAspectRatio='xMidYMid slice']")
    private WebElement musalaFBProfilePic;



    //The Methods
    @Step("Get the Current page")
    public static String CompanyPageUrl() {
        return driver.getCurrentUrl();
    }
    @Step("Verify that the Leadership section is displayed inside Current Page")
    public boolean isThisSectionDisplayed(String searchWord) {
        return driver.getPageSource().contains(searchWord);
    }
    @Step("Click on Facebook icon from footer to open Facebook page")
    public CompanyPage clickOnFaceBookIcon() {
        facebookIcon.click();
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
    @Step("Get the Musala’s Facebook Page URL")
    public String getURL() {
        return driver.getCurrentUrl();
    }
    @Step("Verify that this is Musala’s Profile Pic is displayed in Facebook Page ")
    public boolean isMusalaProfilePicDsplayed() {
        hoverOnTheElement(musalaFBProfilePic);
        return musalaFBProfilePic.isDisplayed();
    }
}
