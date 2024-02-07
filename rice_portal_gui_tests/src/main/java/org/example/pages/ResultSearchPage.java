package org.example.pages;

import org.example.pages.elements.Header;
import org.openqa.selenium.WebDriver;

public class ResultSearchPage   extends ParentPage{
    private Header header;
    public Header getHeader() {
        return header = new Header(webDriver);
    }

    public ResultSearchPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Override
    protected String getRelativeUrl() {
        return "/search/[a-zA-z0-9]*";
    }

    public ResultSearchPage checkIsRedirectedToSearchResultPage() {
        checkUrlWithPattern();
        //TODO check element
        return this;
    }

}
