package com.musala.testcases;

import com.musala.base.BaseTest;
import com.musala.pages.ApplyPositionPage;
import com.musala.pages.CareersPage;
import com.musala.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 extends BaseTest {

    @Story("Test Case 3")
    @Description("it will be open Musala website then navigate to Careers page then Join Us Page ")
    @Test(priority = 0 , description = "Verify that user navigated to Join Us Page ")
    public void IsJoinUsPageOpened() {
        HomePage homePage = new HomePage(getDriver());
        CareersPage careerPage = new CareersPage(getDriver());
        homePage
                .loadWebSite()
                .clickOnAcceptAllCookiesButton()
                .clickOnCareerButton()
                .clickOnPositionsButton();
        Assert.assertEquals(careerPage.getUrl(),
                "https://www.musala.com/careers/join-us/");
    }

    @Test(priority=1,description="Verify that the 4 main sections are Displayed on an open position page" )
    @Description("Verify that the 4 main sections are Displayed: General Description, Requirements, Responsibilities, What we offer")
    public void verifyMainSectionsDisplayed()
    {
        HomePage homePage = new HomePage(getDriver());
        CareersPage careerPage = new CareersPage(getDriver());
        homePage
                .loadWebSite()
                .clickOnAcceptAllCookiesButton()
                .clickOnCareerButton()
                .clickOnPositionsButton()
                .selectLocationBy("Anywhere")
                .choosePosition("Automation QA Engineer")
                .scrollDown();
        Assert.assertTrue(careerPage.verifyMainSectionsDisplayed());
    }

    @Test(priority=2,description="Verify that Apply button is presented at the bottom " )
    @Description("Verify that the apply button is presented at the bottom  on an open position page")
    public void verifyApplyButtonIsPresent()
    {
        HomePage homePage = new HomePage(getDriver());
        CareersPage careerPage = new CareersPage(getDriver());
        homePage
                .loadWebSite()
                .clickOnAcceptAllCookiesButton()
                .clickOnCareerButton()
                .clickOnPositionsButton()
                .selectLocationBy("Anywhere")
                .choosePosition("Automation QA Engineer")
                .scrollDown();
        Assert.assertTrue(careerPage.isApplyButtonPresented());
    }

    @Test(priority=3,description="Verify Error messages are shown for invalid data on Form" )
    @Description("Verify shown error messages  The field is required and The e-mail address entered is invalid etc")
    public void verifyApplyErrorMessagesAreShown()
    {
        HomePage homePage = new HomePage(getDriver());
        CareersPage careerPage = new CareersPage(getDriver());
        homePage
                .loadWebSite()
                .clickOnAcceptAllCookiesButton()
                .clickOnCareerButton()
                .clickOnPositionsButton()
                .selectLocationBy("Anywhere")
                .choosePosition("Automation QA Engineer")
                .scrollDown()
                .clickOnApplyButton();
        ApplyPositionPage applyPositionPage = new ApplyPositionPage(getDriver());
          applyPositionPage
              .fillApplyPositionForm(
                 "Testerman",
                   "test@@@@",
                      "",
                        "src/test/java/com/musala/Data/IbrahimShafikCV.pdf")
              .clickOnSendButton();
        Assert.assertEquals(ApplyPositionPage.isEmailValidationDisplayed(),
                "The e-mail address entered is invalid.");
        Assert.assertEquals(ApplyPositionPage.isMobileValidationDisplayed(),
               "The field is required.");
    }
}
