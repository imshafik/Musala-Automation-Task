package com.musala.testcases;

import com.musala.base.BaseTest;
import com.musala.pages.CompanyPage;
import com.musala.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 extends BaseTest {
    @Story("Test Case 2")
    @Description("it will be open Musala website then navigate to company page then Verify the Opened Page and the Leadership section")
    @Test(priority= 1 ,description = "Verify if User can navigate to Company Page and the displayed Leadership section")

    public void verifyCompanyPageURLandLeadershipSection()
    {
        HomePage homePage = new HomePage(getDriver());
        CompanyPage companyPage = new CompanyPage(getDriver());

        homePage
                .loadWebSite()
                .clickOnAcceptAllCookiesButton()
                .clickOnCompanyButton()
                .scrollDown();
        Assert.assertEquals(CompanyPage.getURL(),
                "https://www.musala.com/company/");
        Assert.assertTrue(companyPage.isThisSectionDisplayed("Leadership"));

    }

    @Test(priority=2,description="Verify if User can navigate to Company Page then Facebook Page and profile picture Displayed")
    @Description("Verify that the User navigated to the correct Facebook Page Opens and that the profile picture Displayed")
    public void verifyFBurlAndPorfileImg() throws InterruptedException {

        HomePage homePage = new HomePage(getDriver());
        CompanyPage companyPage = new CompanyPage(getDriver());
        homePage
                .loadWebSite()
                .clickOnAcceptAllCookiesButton()
                .clickOnCompanyButton()
                .scrollDown();
        companyPage.clickOnFaceBookIcon();
        Assert.assertEquals(companyPage.getURL(),
                "https://web.facebook.com/MusalaSoft?fref=ts&_rdc=1&_rdr");
        Assert.assertTrue(companyPage.isMusalaProfilePicDsplayed());
    }
}


