package com.musala.testcases;

import com.musala.Data.ExcelReader;
import com.musala.base.BaseTest;
import com.musala.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

@Feature("Test Case 1")
public class TestCase1 extends BaseTest {
    @DataProvider(name="ExcelData")
    public Object[][] UserData() throws IOException
    {
        // get data from Excel Reader class
        ExcelReader ER = new ExcelReader();
        return ER.getExcelData();
    }

    @Story("Test Case 1")
    @Description("Verify that error message The e-mail address entered is invalid appears")
    @Test(dataProvider="ExcelData" , description = "Verify that error message The e-mail address entered is invalid appears")
    public void shouldBeAbleToValidateEmail(String mail) throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .loadWebSite()
                .clickOnAcceptAllCookiesButton()
                .scrollDown()
                .clickOnContactUsButton()
                .fillNameData("Ibrahim Shafik")
                .fillEmail(mail)
                .fillSubject("Test Subject")
                .fillMessage("Test Message")
                .clickOnSendButton();
        Assert.assertEquals(homePage.getValidationMessage(),
                                "The e-mail address entered is invalid.");
    }
}
