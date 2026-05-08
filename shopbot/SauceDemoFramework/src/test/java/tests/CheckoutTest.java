package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutFlow() {

        LoginPage login = new LoginPage(driver);

        login.login("standard_user", "secret_sauce");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        driver.findElement(By.className("shopping_cart_link")).click();

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("Sivani");
        driver.findElement(By.id("last-name")).sendKeys("B");
        driver.findElement(By.id("postal-code")).sendKeys("600001");

        driver.findElement(By.id("continue")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("inventory_item_name")));

        String productName = driver.findElement(
                By.className("inventory_item_name")).getText();

        Assert.assertEquals(productName, "Sauce Labs Backpack");

        driver.findElement(By.id("finish")).click();

        String successMsg = driver.findElement(
                By.className("complete-header")).getText();

        Assert.assertEquals(successMsg,
                "Thank you for your order!");
    }
}