package com.rappidtech.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_12_VerifyCheckout extends TestBase {
    /*
    As a user when I login to SauceDemo and I Click on Add to cart icon and I click on Checkout button
    I should be able to see the checkout page label {Checkout: Your Information}
    I should be able to see the for for {First Name}{Last Name}{Zip/Postal Code}
    I should be able to see the two buttons {Cancel} and {Continue}
     */
    private static final Logger logger = LogManager.getLogger(TC_12_VerifyCheckout.class);
    @Test
    public void verify_Checkout() {
        loginPage.loginUsingValidCredentials();
        mainPage.clickOnShoppingCartLinkIcon();
        cartPage.clickOnCheckoutButton();
        Assert.assertTrue(checkoutPage.isCheckoutLabelDisplayed());
        Assert.assertTrue(checkoutPage.isFirstNameBoxDisplayed());
        Assert.assertTrue(checkoutPage.isLastNameBoxDisplayed());
        Assert.assertTrue(checkoutPage.isPostalCodeBoxDisplayed());
        Assert.assertTrue(checkoutPage.isContinueButtonDisplayed());
    }
}