package com.musala.testcases;

import com.musala.base.BaseTest;
import com.musala.pages.CompanyPage;
import com.musala.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Test Case 2")
public class TestCase2 extends BaseTest {
    @Story("Test Case 2")
    @Description("it will be open Musala website then navigate to company page then Verify the Opened Page")
    @Test(priority= 0 ,description = "Verify if User can navigate to Company Page")

    public void verifyCompanyPageURL()
    {
        HomePage homePage = new HomePage(getDriver());
        CompanyPage companyPage = new CompanyPage(getDriver());

        homePage
                .loadWebSite()
                .clickOnAcceptAllCookiesButton()
                .clickOnCompanyButton();
        Assert.assertEquals(CompanyPage.getURL(),
                "https://www.musala.com/company/");
    }

    @Test(priority=1,description="Verify that the Leadership section is Displayed in Page")
    @Description("Verify that the Leadership section is displayed inside Current Page")
    public void verifyLeadershipSection()
    {
        HomePage homePage = new HomePage(getDriver());
        CompanyPage companyPage = new CompanyPage(getDriver());

        homePage
                .loadWebSite()
                .clickOnAcceptAllCookiesButton()
                .clickOnCompanyButton();
        Assert.assertTrue(companyPage.isThisSectionDisplayed("Leadership"));
    }

    @Test(priority=2,description="Verify if User can navigate to Company Page then Facebook Page and profile picture Displayed")
    @Description("Verify that the User navigated to the correct Facebook Page Opens and that the profile picture Displayed")
    public void verifyFBURLAndPorfileImg() throws InterruptedException {

        HomePage homePage = new HomePage(getDriver());
        CompanyPage companyPage = new CompanyPage(getDriver());
        homePage
                .loadWebSite()
                .clickOnAcceptAllCookiesButton()
                .clickOnCompanyButton()
                .clickOnFaceBookIcon();
        Assert.assertEquals(companyPage.getURL(),
                "https://www.facebook.com/MusalaSoft?fref=ts");
        Assert.assertTrue(companyPage.isMusalaProfilePicDsplayed());
    }
}


