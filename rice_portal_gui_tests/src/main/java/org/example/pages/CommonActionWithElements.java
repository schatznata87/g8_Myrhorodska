package org.example.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActionWithElements {
    Logger logger = Logger.getLogger(getClass());
    protected WebDriver webDriver;

    protected WebDriverWait webDriverWait10;

    public CommonActionWithElements (WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);//this - means all elements from this class will be initialized FindBy
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    private String getElementName(WebElement element) {
        try {
            return element.getAccessibleName();
        }catch (Exception e){
            return "";
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }

    public void clickOnElement(WebElement element) {
        try {
            String elementName = getElementName(element);
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info(elementName + " Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElement (String locator) {
        try {
            clickOnElement(webDriver.findElement(By.xpath(locator)));
        } catch (Exception e) {
            logger.error(" Can't work with locator ");
            Assert.fail(" Can't work with locator ");
        }
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            boolean state = element.isDisplayed();
            if (state) {
                logger.info("Element " + getElementName(element) + " is displayed -> " + state);
                return true;
            } else {
                logger.info("Element is not displayed ");
                return false;
            }
        } catch (Exception e) {
            logger.error("Can not work with element ");
            //     Assert.fail("Can not work with element ");
            return false;
        }
    }
    protected void enterTextInToInput(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted into input" + getElementName(element));
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }
    public  void clickOnElementThrowable(WebElement element) {

        String elementName = getElementName(element);
        webDriverWait10.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        logger.info(elementName + " Element was clicked");

    }
    protected void checkIsElementVisible(WebElement webElement) {
        Assert.assertTrue("Element is not visible", isElementDisplayed(webElement));
    }

    public void checkElementDisplayed(WebElement element) {
        Assert.assertTrue("Element is not displayed", isElementDisplayed(element));
    }
    public void pressEnterKey(){
        try{
            Actions actions = new Actions(webDriver);
            actions.sendKeys(Keys.ENTER).build().perform();
            logger.info("Enter key was pressed");
        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }
    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
}}
