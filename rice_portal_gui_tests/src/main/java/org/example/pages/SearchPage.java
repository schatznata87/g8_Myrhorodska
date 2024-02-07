package org.example.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.ResultSet;

public class SearchPage extends ParentPage {

   @FindBy (xpath= "//*[@id=\"input-search\"]")
   private WebElement inputSearch;

   @FindBy(xpath= "//*[@id=\"button-search\"]")
   private WebElement  searchButtonOnSearchPage;

   //@FindBy (xpath = "//*[@id=\"content\"]/div[1]/div[1]/select")
    //private WebElement dropDownSelectValue;
    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    private static String SavedTextOfSearchFieldWhichWasEnteredOnSearchPage;
    @Override
    protected String getRelativeUrl() {
        return "/search/";
    }


    public SearchPage checkIsRedirectOnSearchPage() {
        checkUrl();
        return this;
    }
    public SearchPage enterTextInToInputSearch(String input) {
        //TODO enter text in to input Title
        enterTextInToInput(inputSearch, input);
        this.SavedTextOfSearchFieldWhichWasEnteredOnSearchPage = input;
        return this;
    }
    public static String getEnteredTitle() {
        return SavedTextOfSearchFieldWhichWasEnteredOnSearchPage;
    }


  //  public SearchPage checkOnPostWithTitle(String searchButtonOnSearchPage) {
//        clickOnElement(webDriver.findElement(By.xpath(String.format(postTitleLocator, postTitle))));//findElement - шукає елемент can return null

        //    clickOnElement(getPostsList(postTitle).get(0));//click on first post in the list клікнути на перший пост в списку
    //    clickOnElement(String.format(searchButtonOnSearchPage, searchButtonOnSearchPage)); //findElement - шукає елемент can return null
     //   return this;
    //}
    public ResultSearchPage clickOnSearchPageButton() {
        clickOnElement(searchButtonOnSearchPage);
        return new ResultSearchPage(webDriver);
    }
    //select text in drop down
}