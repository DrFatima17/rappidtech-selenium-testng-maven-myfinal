package com.rappidtech.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.rappidtech.utilities.SeleniumUtils;

public class CartPage {
    private static final Logger logger = LogManager.getLogger(CartPage.class);
    WebDriver driver;

    /**
     * Constructor to initialize the Webdriver and elements on the page
     *
     * @param driver is the driver that need to be passed when we create object of the Login page
     */
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='continue-shopping']")
    WebElement continueButton;

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='cart_quantity_label']")
    WebElement qtyLabel;

    @FindBy(xpath = "//div[@class='cart_desc_label']")
    WebElement descriptionLabel;
    @FindBy(xpath = "//div[@class='cart_item']")
    WebElement cartItemDisplayBox;

    @FindBy(xpath = "//div[.='Sauce Labs Backpack']")
    WebElement backPackInCart;
    @FindBy(xpath = "//div[.='carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.']")
    WebElement backPackDescriptionCartPage;

    @FindBy(xpath = "//div[@class='inventory_item_price'][.='$29.99']")
    WebElement backPackPriceInCart;

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement continueButtonInCartPage;



    //+++++++++++++++++++++++++++++++++++++++++++++ Method / Functions +++++++++++++++++++++++++++++++++++++++++++++++

    /**
     * Will check if the continue button in the Cart page is displayed or not
     *
     * @return
     */
    public boolean isContinueButtonDisplayed() {
        logger.info("Check is the continue button is displayed or not");
        SeleniumUtils.waitForVisibilityOfElement(driver, continueButton);
        return continueButton.isDisplayed();
    }

    /**
     * Will check if the checkout button in the Cart page is displayed or not
     *
     * @return
     */
    public boolean isCheckoutButtonDisplayed() {
        logger.info("Check is the checkout button is displayed or not");
        SeleniumUtils.waitForVisibilityOfElement(driver, checkoutButton);
        return checkoutButton.isDisplayed();
    }

    /**
     * Will check if the qty label in the Cart page is displayed or not
     *
     * @return
     */
    public boolean isQtyLabelDisplayed() {
        logger.info("Check is the qty label is displayed or not");
        SeleniumUtils.waitForVisibilityOfElement(driver, qtyLabel);
        return qtyLabel.isDisplayed();
    }

    /**
     * Will check if the Description label in the Cart page is displayed or not
     *
     * @return
     */
    public boolean isDescriptionLabelDisplayed() {
        logger.info("Check is the Description label is displayed or not");
        SeleniumUtils.waitForVisibilityOfElement(driver, descriptionLabel);
        return descriptionLabel.isDisplayed();
    }

    public boolean isItemAddedToCartInCartPage() {
        logger.info("Check is the Item added to cart is seen on cart page or not");
        SeleniumUtils.waitForVisibilityOfElement(driver, cartItemDisplayBox);
        return cartItemDisplayBox.isDisplayed();

    }

    public String getBackPackItemLabel() {
        logger.info("Getting the label of the BackPack item from Cart page");
        return backPackInCart.getText();
    }

    public String getBackPackDescriptionLabel() {
        logger.info("Getting the Description of the BackPack item from Cart page");
        return backPackDescriptionCartPage.getText();
    }

    public String getBackPackPriceLabel() {
        logger.info("Getting the Price of the BackPack item from Cart page");
        return backPackPriceInCart.getText();
    }

    public void clickOnCheckoutButton() {
        logger.info("Clicking on checkout button in cartpage ");
        continueButtonInCartPage.click();
    }
}