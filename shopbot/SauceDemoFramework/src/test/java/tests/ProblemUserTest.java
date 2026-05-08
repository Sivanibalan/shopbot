package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.List;

public class ProblemUserTest extends BaseTest {

    @Test
    public void verifyProblemUserImages() {

        LoginPage login = new LoginPage(driver);

        login.login("problem_user", "secret_sauce");

        List<WebElement> images = driver.findElements(By.tagName("img"));

        boolean brokenImageFound = false;

        for (WebElement img : images) {

            String src = img.getAttribute("src");

            System.out.println(src);

            if (src.contains("data:image")) {

                brokenImageFound = true;
                break;
            }
        }

        Assert.assertTrue(brokenImageFound,
                "Broken images detected for problem_user");
    }

    @Test
    public void verifyProblemUserAddToCart() {

        LoginPage login = new LoginPage(driver);

        login.login("problem_user", "secret_sauce");

        driver.findElement(
                By.id("add-to-cart-sauce-labs-backpack")).click();

        String badge = driver.findElement(
                By.className("shopping_cart_badge")).getText();

        Assert.assertEquals(badge, "1");
    }
}