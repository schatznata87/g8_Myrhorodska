package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage extends CommonActionsWithElements {
    final String baseUrl = "https://dev160-rice-eda-portal-web.rice-test.merlin/";

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    //method for checking if we are on the page

    abstract protected String getRelativUrl();

    protected void checkUrl() {
        //TODO
        Assert.assertEquals("Invalid page"
                , baseUrl + getRelativUrl(),
                webDriver.getCurrentUrl());
    }

    protected void checkUrlWithPattern() {
        Assert.assertTrue("Invalid page \n" +
                        "Expected: " + baseUrl + getRelativUrl() + "\n" +
                        "Actual: " + webDriver.getCurrentUrl(),
                webDriver.getCurrentUrl().matches(baseUrl + getRelativUrl()));
    }
}