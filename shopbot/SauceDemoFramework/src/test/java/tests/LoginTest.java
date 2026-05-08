
package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage login = new LoginPage(driver);

        login.login("standard_user", "secret_sauce");

        String actualTitle = driver.getCurrentUrl();

        Assert.assertTrue(actualTitle.contains("inventory"));
    }

    @Test
    public void lockedUserTest() {

        LoginPage login = new LoginPage(driver);

        login.login("locked_out_user", "secret_sauce");

        String error = login.getErrorMessage();

        Assert.assertTrue(error.contains("locked out"));
    }

    @Test
    public void emptyLoginTest() {

        LoginPage login = new LoginPage(driver);

        login.login("", "");

        String error = login.getErrorMessage();

        Assert.assertTrue(error.contains("Username is required"));
    }
}