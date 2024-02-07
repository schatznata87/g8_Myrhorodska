package org.example.pages;

import org.example.libs.ConfigProvider;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage extends CommonActionWithElements{


    final String baseUrl = ConfigProvider.configProperties.BASE_URL();



    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    //check url
    // https://aqa-complexapp.onrender.com/ == BASE_URL+ "/"-> true
    protected void checkCurrentUrl(String relativeUrl) {
        Assert.assertEquals("Url is not expected", baseUrl + relativeUrl, webDriver.getCurrentUrl());
    }

    abstract protected String getRelativeUrl();

    public void checkUrl() {
        Assert.assertEquals("Invalid page",
                baseUrl + getRelativeUrl(),
                webDriver.getCurrentUrl());
    }
    protected void checkUrlWithPattern() {
        Assert.assertTrue("Invalid page \n" +
                        "Expected: " + baseUrl + getRelativeUrl() +"\n" +
                        "Actual: " + webDriver.getCurrentUrl(),
                webDriver.getCurrentUrl().matches(baseUrl + getRelativeUrl()));
    }
    protected void openPage(String url) {
        try {
            webDriver.get(url);
            logger.info("Page " + url + " was opened");
        } catch (Exception e) {
            logger.error("Can not open " + url);
            Assert.fail("Can not open " + url);
        }
    }
}
