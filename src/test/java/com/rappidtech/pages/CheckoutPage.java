package com.rappidtech.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.rappidtech.utilities.SeleniumUtils;

public class CheckoutPage {
    private static final Logger logger = LogManager.getLogger(CheckoutPage.class);
    WebDriver driver;

    /**
     * Constructor to initialize the webdriver and elements on the page
     * @param driver is the driver that need to be passed when we create object of the Login page
     */
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='title']")
    WebElement checkoutTitle;
    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstNameBox;
    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastNameBox;
    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement postalCodeBox;
    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;
    @FindBy(xpath = "//button[@id='cancel']")
    WebElement cancelButton;

    //+++++++++++++++++++++++++++++++++ Methods / Functions ++++++++++++++++++++++++++++++++++++++++//

    /**
     * This method will return true or false if the checkout label is displayed or not
     * @return true/false
     */
    public boolean isCheckoutLabelDisplayed(){
        logger.info("Checking if Main Logo is displayed or not");
        SeleniumUtils.waitForVisibilityOfElement(driver, checkoutTitle);
        return checkoutTitle.isDisplayed();
    }

    /**
     * This method will return true or false if the first name box is displayed or not
     * @return true/false
     */
    public boolean isFirstNameBoxDisplayed(){
        logger.info("Checking if Main Logo is displayed or not");
        SeleniumUtils.waitForVisibilityOfElement(driver, firstNameBox);
        return firstNameBox.isDisplayed();
    }

    /**
     * This method will return true or false if the last name box is displayed or not
     * @return true/false
     */
    public boolean isLastNameBoxDisplayed(){
        logger.info("Checking if Main Logo is displayed or not");
        SeleniumUtils.waitForVisibilityOfElement(driver, lastNameBox);
        return lastNameBox.isDisplayed();
    }

    /**
     * This method will return true or false if the postal code box is displayed or not
     * @return true/false
     */
    public boolean isPostalCodeBoxDisplayed(){
        logger.info("Checking if Main Logo is displayed or not");
        SeleniumUtils.waitForVisibilityOfElement(driver, postalCodeBox);
        return postalCodeBox.isDisplayed();
    }

    /**
     * This method will return true or false if the continue button is displayed or not
     * @return true/false
     */
    public boolean isContinueButtonDisplayed(){
        logger.info("Checking if Main Logo is displayed or not");
        SeleniumUtils.waitForVisibilityOfElement(driver, continueButton);
        return continueButton.isDisplayed();
    }

    /**
     * This method will return true/false if field is displayed or not
     * @return true/false
     */
    public boolean isCancelButtonDisplayed(){
        logger.info("Checking if element is displayed");
        return cancelButton.isDisplayed();
    }

    public void enterCredentialsInCheckoutPage(String firstName,String lastName,String zipcode){
        logger.info("Entering First name,Last name and Postal code into the fields and click continue button");
        firstNameBox.sendKeys(firstName);
        lastNameBox.sendKeys(lastName);
        postalCodeBox.sendKeys(zipcode);
        continueButton.click();
    }
}