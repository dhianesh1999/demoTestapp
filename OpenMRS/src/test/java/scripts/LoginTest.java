package scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pomPages.LoginPom;
import utilities.BaseClass;
import utilities.utilities;

public class LoginTest extends BaseClass {

    @Test
    public void tc_001_logIn() throws IOException {
        LoginPom login = new LoginPom(driver);

        login.enterUsername(utilities.propertyFile("username"));
        login.enterPassword(utilities.propertyFile("password"));
        login.selectLocation();
        login.clickLogin();

        Assert.assertTrue(login.verifyLogin());
    }
}

