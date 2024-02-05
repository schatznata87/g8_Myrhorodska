package pages.header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;

public class Header  extends CommonActionsWithElements {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/button")
    private WebElement buttonSingIn;

    public Header(WebDriver webDriver) {
        super(webDriver);
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

