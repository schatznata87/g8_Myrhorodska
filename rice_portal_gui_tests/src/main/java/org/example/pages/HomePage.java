package org.example.pages;

import org.example.pages.elements.Header;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {


    private Header header;
    @FindBy(xpath = "//*[@id='search']/div/div/button]")
    private WebElement searchButton;
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }
    public HomePage checkIsredirectToHomePage() {
        checkUrl();
        return this; //перевірка чи ми на сторінці
    }
    public Header getHeader() {
        return new Header(webDriver);
    }

    public void openHomePage() {
        try {
            webDriver.get(baseUrl);
            logger.info("Home page was opened"+ baseUrl);
        } catch (Exception e) {
            logger.error("Can not open Home Page");
            Assert.fail("Can not open Home Page");
        }
    }
    public void checkIsRedirectToHomePage() {
        checkUrl();
    }


    public SearchPage clickOnButtonSearch() {
        clickOnElement(searchButton);
        return new SearchPage(webDriver);
    }
    public boolean isButtonSearchDisplayed() {
        return isElementDisplayed(searchButton);
    }

}