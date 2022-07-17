package com.musala.testcases;

import com.musala.base.BaseTest;
import com.musala.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class Case4Test extends BaseTest {

    @Story("Test Case 4")
    @Description("it will be open Musala website then navigate to Careers page then Filter the available positions by available cities (Sofia and Skopje) & Print in the console the list")
    @Test(description = "Verify if system display and print the selected city positions")
    public void  filterAndPrintAvailablePositionsByCity() {
        HomePage homePage = new HomePage(getDriver());

        homePage
                .loadWebSite()
                .clickOnAcceptAllCookiesButton()
                .clickOnCareerButton()
                .clickOnPositionsButton()
                .selectLocationBy("Sofia")
                .printAvailablePositionsInConsole("Sofia")
                .selectLocationBy("Skopje")
                .printAvailablePositionsInConsole("Skopje");
    }
}
