package com.rappidtech.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.rappidtech.utilities.ConfigurationReader;

public class LoginPage {
    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    public WebDriver driver;

    /**
     * Constructor to initialize the WebDriver and elements on the page
     * @param driver is the driver that need to be passed when we create object of the Login page
     */

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement userNameField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement submitButton;
    @FindBy(xpath = "//h3[.='Epic sadface: Sorry, this user has been locked out.']")
    WebElement lockedOutError;
    @FindBy(xpath = "//div[@id='login_credentials']")
    WebElement listOfAcceptedUsername;
    @FindBy(xpath = "//h3[.='Epic sadface: Username is required']")
    WebElement userNameRequiredMessage;
    @FindBy(xpath = "//h3[.='Epic sadface: Password is required']")
    WebElement passwordRequiredMessage;
    @FindBy(xpath = "//h3[.='Epic sadface: Username and password do not match any user in this service']")
    WebElement wrongUserNameAndPasswordLabel;


    //+++++++++++++++++++++++++++++++++ Methods / Functions ++++++++++++++++++++++++++++++++++++++++//
    /**
     * This method will enter a username into the username field
     * @param -userName the username we trying to enter
     */
    public void enterUserName(String username){
        logger.info("Entering username: {" + username + "} into the username field" );
        userNameField.sendKeys(username);
    }

    /**
     * This method will enter a password into the password field
     * @param password
     */
    public void enterPassword(String password){
        logger.info("Entering password: {" + password + "} into the password field" );
        passwordField.sendKeys(password);
    }

    /**
     * This method will perform a click on the submit button
     */
    public void clickOnSubmitButton(){
        logger.info("Clicking on submit button" );
        submitButton.click();
    }

    /**
     * This method will login to sauce labs when adding valid credentials using ConfigurationReader
     */
    public void loginUsingValidCredentials() {
        enterUserName(ConfigurationReader.getProperty("validUserName"));
        enterPassword(ConfigurationReader.getProperty("validPassword"));
        clickOnSubmitButton();
    }

    /**
     * This method will return the text when the user enter a locked-out username
     * @return
     */
    public String getLockedOutErrorMessage(){
        logger.info("Getting the locked out user message from the login page");
        return lockedOutError.getText();
    }

    /**
     * This method will get the list of the valid usernames from the UI and return it in the form
     * of an array
     * @return array of the valid user list
     */
    public String[] getListOfAcceptedUserNames(){
        logger.info("Getting the list of the valid usernames");
        String listOfValidUsers = listOfAcceptedUsername.getText().split(":")[1];
        //using the split means you have an array of strings based on how you split the string
        String[] arrayOfValidUsers = listOfValidUsers.split("\n");
        // this (above line) will have an extra empty index at position 0
        String[] finalValidUserList  = new String[arrayOfValidUsers.length-1];
        // we had to copy(above line) over the old array into new array and get rid of the index 0 by saying length-1
        for(int i = 1 ; i <=arrayOfValidUsers.length-1 ; i++){ // i=1 ,means we don't want to add the space
            finalValidUserList[i-1] = arrayOfValidUsers[i];// i-1 means the first element is placed at 0 index in new array
        }
        return finalValidUserList;
    }

    /**
     * This method will return a message if the user doesn't enter a username into the username field
     * @return String - error message that is displayed as error
     */
    public String getUserNameRequiredErrorMessage(){
        logger.info("Getting the error message for the required username");
        return userNameRequiredMessage.getText();
    }

    /**
     * This method will return a message if the user doesn't enter a password into the password field
     * @return String - error message that is displayed as error
     */
    public String getPasswordRequiredErrorMessage(){
        logger.info("Getting the error message for the required password");
        return passwordRequiredMessage.getText();
    }

    /**
     * This method will get the error message when user enter wrong username and password
     * @return text -> The error message when user enter wrong username and password
     */
    public String getErrorMessageForWrongUserNamePassword(){
        logger.info("Getting the error message when selecting wrong username and password");
        return wrongUserNameAndPasswordLabel.getText();
    }
}