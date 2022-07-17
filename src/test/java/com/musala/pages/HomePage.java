package com.musala.pages;

import com.musala.base.BasePage;
import com.musala.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {

        //Constructor
        super(driver);
    }

    //The Elements
    @FindBy( id="wt-cli-accept-all-btn")
    private WebElement acceptCookiesButton;
    @FindBy(css = "[data-alt='Contact us']")
    private WebElement contactUsButton;
    // @FindBy(xpath = "//*[@id='menu-main-nav-1']/li[1]/a")
    @FindBy(linkText = "COMPANY")
    //@FindBy(xpath = "//div[@id='menu']//a[contains(.,'COMPANY')]")
    private WebElement companyButton;

    @FindBy(css = "#content > div.entry-header > div > div.image-overlay > div > h1")
    private WebElement companyHeader;
    @FindBy(xpath = "//div[@id='menu']//a[contains(.,'Careers')]")
    private WebElement careerButton;
    @FindBy(css = "#content > div.entry-header > div > div.image-overlay > div > h1")
    private WebElement careerHeader;
    @FindBy(name="your-name")
    private WebElement nameInput;
    @FindBy(name="your-email")
    private WebElement  emailInput;
    @FindBy(name="your-subject")
    private WebElement  subjectInput;
    @FindBy(name="your-message")
    private WebElement  messageInput;
    @FindBy(css = "[value='Send']")
    private WebElement  sendButton;
    @FindBy(xpath = "//*[@id=\"wpcf7-f875-o1\"]/form/p[2]/span/span")
    private WebElement  emailValidationMessage;



    //The Methods
    @Step("Visit http://www.musala.com/")
    public HomePage loadWebSite() {
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return new HomePage(driver);
    }
    @Step("Click on Accept Cookies")
    public HomePage clickOnAcceptAllCookiesButton() {
        acceptCookiesButton.click();
        return new HomePage(driver);
    }
    @Step("Scroll down ")
    public HomePage scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        return new HomePage(driver);
    }
    @Step("Fill Name Input inside the contactus Form")
    public HomePage fillNameData(String senderName) {
        nameInput.clear();
        nameInput.sendKeys(senderName);
        return new HomePage(driver);
    }
    @Step("Fill Email Data Input inside the contactus Form using Invalid Emails from UserData.xlsx sheet")
    public HomePage fillEmail(String senderEmail){
        emailInput.clear();
        emailInput.sendKeys(senderEmail);
        return new HomePage(driver);
    }
    @Step("Fill Subject Data inside the contactus Form")
    public HomePage fillSubject(String senderSubject){
        nameInput.clear();
        subjectInput.sendKeys(senderSubject);
        return new HomePage(driver);
    }
    @Step("Fill Message data inside the contactus Form")
    public HomePage fillMessage(String senderMessage){
        nameInput.clear();
        messageInput.sendKeys(senderMessage);
        return new HomePage(driver);
    }
    @Step("Click on Send button")
    public HomePage clickOnSendButton() throws InterruptedException {
        sendButton .click();
        Thread.sleep(8000);
        return new HomePage(driver);
    }

    @Step("Get Error Message for invalid email")
    public String getValidationMessage() {
        visibilityOfElement(emailValidationMessage);
        String invalidMessageText = emailValidationMessage.getText();
        return invalidMessageText;
    }

    @Step("Click on Contact us Button to Open Contact us Form")
    public HomePage clickOnContactUsButton() {
       // waitElement(contactUsButton);
        contactUsButton.click();
        return new HomePage(driver);
    }
    @Step("Click on Contactus Button to Open Company Page ")
    public CompanyPage clickOnCompanyButton() {
       // waitElementToClickable(companyButton);
        waitElementToClickable(driver,60,companyButton);
        clickByJavascript(companyButton);
        visibilityOfElement(companyHeader);
        return new CompanyPage(driver);
    }


    @Step("Navigate to Careers menu (from the top)")
    public CareersPage clickOnCareerButton() {
        waitElementToClickable(driver,60,careerButton);
        clickByJavascript(careerButton);
        visibilityOfElement(careerHeader);
        return new CareersPage(driver);
    }
}


