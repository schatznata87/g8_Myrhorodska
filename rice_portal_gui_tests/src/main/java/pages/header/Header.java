package pages.header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;

public class Header  extends CommonActionsWithElements {

    @FindBy(xpath = "//.//div[@class='pniDPk']")
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

