package org.example;
/*зайти на домашню сторінку
  знайти кнопку пошуки
  перевірити чи цей елемент видимий
  нажати на нього
  перейти на сторінку пошуку
  ввести значення пошуку в локатор inputSearch
  нажати на кнопку пошук на пошуковій сторінці
  перейти на сторінку результату пошуку
  ....
*/

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class SearchTest  extends BaseTest {
    final String SEARCH_BODY = "Штани";
    @Test
    public void searchButtonTest() {
        pageProvider.getHomePage().openHomePage();
        Assert.assertTrue("Button Search is not visible", pageProvider.homePage().isButtonSearchDisplayed());
        pageProvider.getHomePage().clickOnButtonSearch();

    }
}