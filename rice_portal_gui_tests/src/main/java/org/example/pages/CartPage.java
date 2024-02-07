package org.example.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends ParentPage {


    @FindBy (xpath = "//*[@id=\"simplecheckout_cart\"]/div[1]/table/tbody/tr/td[2]")
    private List<WebElement> cartItem;
    @FindBy(xpath = "//*[@id=\"simplecheckout_cart\"]/div[1]/table/tbody/tr/td[4]/div/span[2]/button[2]")
    private WebElement deleteProductButton;
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/simplecheckout/";
    }

    public String getProductName(int index) {
        return cartItem.get(index).findElement(By.className("name")).getText();
    }
    public CartPage checkProductName(int index, String expectedProductName) {

        String actualProductName = getProductName(index);

        Assert.assertEquals("Product name is not as expected", expectedProductName, actualProductName);

        logger.info(String.format("Product name is %s", expectedProductName));

        return this;
    }

    public CartPage checkNumberOfCartItems(int expectedNumberOfCartItems) {
        Assert.assertEquals("Number of cart items is not as expected", expectedNumberOfCartItems, cartItem.size());
        logger.info(String.format("Number of cart items is %d", expectedNumberOfCartItems));
        return this;
    }
    public CartPage checkIsRedirectToCardPage() {
        checkUrlWithPattern();
        // TODO check is page title correct
        return this;
    }

    public CartPage clickOnDeleteButton() {
        clickOnElement(deleteProductButton);
        return new CartPage(webDriver);
    }
}