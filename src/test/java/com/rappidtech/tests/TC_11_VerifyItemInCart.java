package com.rappidtech.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_11_VerifyItemInCart extends TestBase {
    /*
    As a User when I login to SauceDemo
    and I Click on Add to cart for the Item {Sauce Labs Backpack}
    And I click on CART icon , I should be able to verify the item is added
    and matching the item added from Product page ,the price and the description is matching too
     */

    private static final Logger logger = LogManager.getLogger(TC_11_VerifyItemInCart.class);

    @Test
    public void verify_Item_Is_Added_To_Cart() throws InterruptedException {
        logger.info("Verifying that after adding SauceLabs Backpack is available in the cart page");
        loginPage.loginUsingValidCredentials();
        mainPage.clickOnAddToCartForBackPackButton();
        mainPage.clickOnShoppingCartLinkIcon();
        Assert.assertTrue(cartPage.isItemAddedToCartInCartPage());
        Assert.assertEquals(cartPage.getBackPackItemLabel(),mainPage.getBackPackItemLabel());
        Assert.assertEquals(cartPage.getBackPackDescriptionLabel(),mainPage.getBackPackDescriptionLabel());
        Assert.assertEquals(cartPage.getBackPackPriceLabel(),mainPage.getBackPackPriceLabel());
    }
}
