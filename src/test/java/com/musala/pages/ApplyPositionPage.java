package com.musala.pages;

import com.musala.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ApplyPositionPage extends BasePage {
    public ApplyPositionPage(WebDriver driver) {
        //Constructor
        super(driver);

    }
    //The Elements
    @FindBy(id = "cf-1")
    private WebElement nameInput;
    @FindBy(id = "cf-2")
    private WebElement emailInput;
    @FindBy(id = "cf-3")
    private WebElement mobileInput;
    @FindBy(id = "uploadtextfield")
    private WebElement uploadFile;
    @FindBy(id = "adConsentChx")
    private WebElement agreementCheckBox;
    @FindBy(css = ".btn-cf-submit")
    private WebElement sendButton;
    @FindBy(css = "#wpcf7-f880-o1 > form > p:nth-child(5) > span > span")
    private static WebElement emailValidationelement;
    private static By emailValidation = By.xpath("//*[@id=\"wpcf7-f880-o1\"]/form/p[3]/span/span");
    @FindBy(className = "message-form-content")
    private static WebElement messageForm;
    @FindBy(className = "close-form")
    private static WebElement closeFormButton;
   // private static By closeFormButton =  By.className("close-form");
    @FindBy(css = ".mobile-number > .wpcf7-not-valid-tip")
    private static WebElement mobileValidation;



    //The Methods
    @Step("Prepare a few sets of negative data leave required field(s) empty enter e-mail with invalid format etc.)")
    public ApplyPositionPage fillApplyPositionForm(String candidateName, String candidateEmail ,String candidateMobile , String cvPath){
        nameInput.sendKeys(candidateName);
        emailInput.sendKeys(candidateEmail);
        mobileInput.sendKeys(candidateMobile);
        uploadFile.sendKeys(cvPath);
        clickByJavascript(agreementCheckBox);
        return new ApplyPositionPage(driver);
    }
    @Step("Click on Send Button after filling data)")
    public ApplyPositionPage clickOnSendButton(){
        clickByJavascript(sendButton);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ApplyPositionPage(driver);
    }
    @Step
    public static String isMobileValidationDisplayed(){
        return mobileValidation.getText();

    }

        @Step("Get Error Message for invalid email")
        public static String getEmailErrorMessage() {
            BasePage.switchWindow();
            BasePage.presenceOfElement(driver, 60, emailValidation);
            String TheInvalidMessage = driver.findElement(emailValidation).getText();
            return TheInvalidMessage;
        }


}
