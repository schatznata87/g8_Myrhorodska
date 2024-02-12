package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CartPage extends Page {

    @FindBy(xpath = "//*[contains(@class, 'js_cart_product_box')]/ul")
    private List<WebElement> cartItems;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getRelativeUrl() {
        return "/shop/cart";
    }

    public CartPage checkRedirectToCardPage() {

        checkUrlWithPattern();

        return this;

    }

    public CartPage checkNumberOfCartItems(int expectedNumberOfCartItems) {

        Assert.assertEquals("Number of cart items is not as expected", expectedNumberOfCartItems, cartItems.size());

        logger.info(String.format("Number of cart items is %d", expectedNumberOfCartItems));

        return this;

    }

    public CartPage checkProductName(int productIndex, String expectedProductName) {

        String actualProductName = getProductName(productIndex);

        Assert.assertEquals("Product name is not as expected", expectedProductName, actualProductName);

        logger.info(String.format("Product name is %s", expectedProductName));

        return this;

    }

    private String getProductName(int productIndex) {

        return cartItems.get(productIndex)
                .findElement(By.className("content-right__info-top"))
                .findElement(By.className("content-right__info-text"))
                .getText();

    }

}
