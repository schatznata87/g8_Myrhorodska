package org.example.pages.elements;

import org.example.pages.CommonActionWithElements;
import org.example.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header  extends CommonActionWithElements {

    @FindBy(xpath = "//*[@id=\"cart\"]/a/i']")
    private WebElement cart;



    public Header(WebDriver webDriver) {
        super(webDriver);
    }




    public void checkIsCartVisible() {
        checkElementDisplayed(cart);
    }

    public boolean isCartVisible() {
        return isElementDisplayed(cart);
    }

    public void clickOnCart() {
        clickOnElement(cart);
    }

}