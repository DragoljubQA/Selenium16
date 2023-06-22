package SauceDemo.SauceTests;

import SauceDemo.SauceBaseTest.SauceBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends SauceBase {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void userCanLogIn() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickOnLogin();
    }

}
