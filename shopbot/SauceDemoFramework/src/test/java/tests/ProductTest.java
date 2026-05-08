package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class ProductTest extends BaseTest {

    @Test
    public void verifyProductsDisplayed() {

        LoginPage login = new LoginPage(driver);

        login.login("standard_user", "secret_sauce");

        ProductPage product = new ProductPage(driver);

        Assert.assertFalse(product.getFirstProductName().isEmpty());
    }

    @Test
    public void sortByNameAToZ() {

        LoginPage login = new LoginPage(driver);

        login.login("standard_user", "secret_sauce");

        Select sort = new Select(driver.findElement(By.className("product_sort_container")));

        sort.selectByVisibleText("Name (A to Z)");

        String firstItem = driver.findElements(By.className("inventory_item_name"))
                .get(0).getText();

        Assert.assertEquals(firstItem, "Sauce Labs Backpack");
    }

    @Test
    public void sortByPriceLowToHigh() {

        LoginPage login = new LoginPage(driver);

        login.login("standard_user", "secret_sauce");

        Select sort = new Select(driver.findElement(By.className("product_sort_container")));

        sort.selectByVisibleText("Price (low to high)");

        String firstPrice = driver.findElements(By.className("inventory_item_price"))
                .get(0).getText();

        Assert.assertEquals(firstPrice, "$7.99");
    }
}
