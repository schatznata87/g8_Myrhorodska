package pages;

import org.openqa.selenium.WebDriver;

public class PageProvider {
    private WebDriver webDriver;
    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public LoginPage loginPage() {
        return new LoginPage(webDriver);
    }

    public CatalogPage homePage() {
        return new CatalogPage (webDriver);
    }
    public ResultPage getPostPage() {
        return new ResultPage(webDriver);
    }
}
