package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/button")
    private WebElement buttonSingIn;

    @Override
    protected String getRelativUrl() {
        return "/";
    }

    public void openLoginPage() {
        try {
            webDriver.get(baseUrl);
            logger.info("Login page was opened"+ baseUrl);
        } catch (Exception e) {
            logger.error("Can not open Login Page");
            Assert.fail("Can not open Login Page");
        }
    }
    public void checkIsRedirectToLoginPage() {
        checkUrl();
    }


    public void checkIsSingInVisible() {
        checkElementDisplayed(buttonSingIn);
    }
    public void clickOnButtonSingIn() {
        clickOnElement(buttonSingIn);
    }
    //is button Sign In visible
    public boolean isButtonSignInVisible() {
        return isElementDisplayed(buttonSingIn);
    }
}
