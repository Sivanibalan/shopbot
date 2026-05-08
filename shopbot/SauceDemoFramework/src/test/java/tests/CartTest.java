
package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class CartTest extends BaseTest {

    @Test
    public void addSingleProductToCart() {

        LoginPage login = new LoginPage(driver);

        login.login("standard_user", "secret_sauce");

        ProductPage product = new ProductPage(driver);

        product.addBackpackToCart();

        Assert.assertEquals(product.getCartCount(), "1");
    }

    @Test
    public void addTwoProductsToCart() {

        LoginPage login = new LoginPage(driver);

        login.login("standard_user", "secret_sauce");

        driver.findElement(
                org.openqa.selenium.By.id("add-to-cart-sauce-labs-backpack")).click();

        driver.findElement(
                org.openqa.selenium.By.id("add-to-cart-sauce-labs-bike-light")).click();

        String count = driver.findElement(
                org.openqa.selenium.By.className("shopping_cart_badge")).getText();

        Assert.assertEquals(count, "2");
    }
}