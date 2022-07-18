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
    @Description("it will be open Musala website then navigate to Careers page then Join Us Page and position page displays the main sections ")
    @Test(priority = 1 , description = "Verify that user navigated to Join Us Page and position page displays the main sections ")
    public void verifyJoinUsPageAndMainSections() {
        HomePage homePage = new HomePage(getDriver());
        CareersPage careerPage = new CareersPage(getDriver());
        homePage
                .loadWebSite()
                .clickOnAcceptAllCookiesButton()
                .clickOnCareerButton()
                .clickOnPositionsButton();
        Assert.assertEquals(careerPage.getUrl(),
                "https://www.musala.com/careers/join-us/");

        careerPage
                .selectLocationBy("Anywhere")
                .choosePosition("Automation QA Engineer")
                .scrollDown();
        Assert.assertTrue(careerPage.verifyMainSectionsDisplayed());
        Assert.assertTrue(careerPage.isApplyButtonPresented());



    }

    @Test(priority=2,description="Verify Error messages are shown for invalid data on Form" )
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
        Assert.assertEquals(ApplyPositionPage.getEmailErrorMessage(),
                "The e-mail address entered is invalid.");
        Assert.assertEquals(ApplyPositionPage.isMobileValidationDisplayed(),
               "The field is required.");
    }
}