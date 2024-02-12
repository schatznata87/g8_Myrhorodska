package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class WomanProductListPage extends Page {

    @FindBy(xpath = "//*[contains(@class, 'products__items')]/div[1]/div")
    private List<WebElement> productList;

    public WomanProductListPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/zhinkam";
    }

    public String getProductName(int productIndex) {

        if (productIndex >= 0 && productIndex < productList.size()) {
            WebElement listItem = productList.get(productIndex);
            WebElement productTitle = listItem.findElement(By.className("card__title"));
            return productTitle.getText();
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

    }

    public String getProductSlug(int productIndex) {

        if (productIndex >= 0 && productIndex < productList.size()) {

            WebElement listItem = productList.get(productIndex);
            WebElement productLink = listItem.findElement(By.className("card__link"));

            String[] relativeUrlParts = productLink.getAttribute("href").split("/");

            return relativeUrlParts[relativeUrlParts.length - 1];

        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

    }

    public ProductPage clickOnProduct(int productIndex) {

        String productSlug = getProductSlug(productIndex);

        logger.info(String.format("Product '%s' was opened", getProductName(productIndex)));

        clickOnElement(productList.get(productIndex));

        return new ProductPage(webDriver, productSlug);

    }

}
