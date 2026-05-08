
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstProduct = By.className("inventory_item_name");
    By cartBadge = By.className("shopping_cart_badge");

    public String getFirstProductName() {

        return driver.findElement(firstProduct).getText();
    }

    public void addBackpackToCart() {

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    public String getCartCount() {

        return driver.findElement(cartBadge).getText();
    }
}