package com.rappidtech.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TC_13_VerifyCheckoutOverview extends TestBase {
    /*
    As a user when I login to SauceDemo and I Click on Add to cart icon for the Item {Sauce Labs Backpack }and {Sauce Labs Bike Light} and I click on Checkout button
    and I enter the First Name , Last Name and Zip/Postal Code and Click on continue
    I should be able to Verify that the :
    Payment Information Label is Displayed
    Shipping Information is Displayed
    Price Total us Displayed with Item total: $39.98 and Tax: $3.20 and Total: $43.18
     */

    private static final Logger logger = LogManager.getLogger(TC_13_VerifyCheckoutOverview.class);

    @Test
    public void verify_Checkout_Information_For_Selected_Items(){
        logger.info("verify Checkout Information For Selected Items");
        loginPage.loginUsingValidCredentials();
        mainPage.clickOnAddToCartForBackPackButton();
        mainPage.clickOnAddToCartForBikeLight();
        mainPage.clickOnShoppingCartLinkIcon();
        cartPage.clickOnCheckoutButton();
        //checkoutPage.enterCredentialsInCheckoutPage(faker.name().firstName(),faker.name().lastName(),faker.address().zipCode());
    }

}