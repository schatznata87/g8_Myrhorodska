package org.example;

import org.example.pages.AllProductsPage;
import org.example.pages.CartPage;
import org.example.pages.ProductPage;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class AddToCartTest extends BaseTest {


    @Test
    public void addToCartTest() {
        int productIndex = 1;
        AllProductsPage allProductsPage = pageProvider.getAllProductsPage().openAllProductPage();
        String productName = allProductsPage.getProductName(productIndex);

        pageProvider.getAllProductsPage()
                .clickOnProduct(productIndex)
                .clickAddToCartButton()
                .addProductToCart()
                .checkNumberOfCartItems(1)
                .checkProductName(0, productName);
    }
}



