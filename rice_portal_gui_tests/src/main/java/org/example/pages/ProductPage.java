package org.example.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage  extends ParentPage{

    private final String productName;
    @FindBy(xpath = "//*[@id=\"button-cart\"]")
    private WebElement addToCartButton;
    public ProductPage(WebDriver webDriver, String productName) {

        super(webDriver);

        this.productName = productName;

    }

    @Override
    protected String getRelativeUrl() {
        return "/katalog/" + productName.toLowerCase().replace(" ", "-");}

    public ProductPage checkIsRedirectOnProductPage() {
        checkUrlWithPattern();
        return this;
    }
    public ProductPage clickAddToCartButton() {

        clickOnElement(addToCartButton);

        logger.info("By  button was clicked");

        return this;

    }
    public CartPage addProductToCart() {

        clickOnElement(addToCartButton);

        logger.info("Product was added to cart");

        return new CartPage(webDriver).checkIsRedirectToCardPage();

    }
    public CartPage checkIsRedirectToCardPage() {
        // Check if the current page is redirected to the cart page
        // This could include verifying the URL, page title, or any other relevant information
        // You may need to implement additional checks based on your application's behavior
        logger.info("Redirected to Cart Page");
        return new CartPage(webDriver);
    }
}
