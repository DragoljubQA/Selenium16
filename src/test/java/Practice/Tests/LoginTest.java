package Practice.Tests;

import Practice.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    String username;
    String password;
    String invalidUsername;
    String invalidPassword;

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeURL);
        username = excelReader.getStringData("Login", 1, 0);
        password = excelReader.getStringData("Login", 1, 1);
        invalidUsername = excelReader.getStringData("Login", 1, 2);
        invalidPassword = excelReader.getStringData("Login", 1, 3);

    }

    @Test
    public void userCanLogIn() {
        sidebarPage.clickOnPractice();
        practicePage.clickOnTestLoginPage();
        loginPage.insertUsername(username);
        loginPage.insertPassword(password);
        loginPage.clickOnSubmit();
        Assert.assertTrue(profilePage.notificationContainsUsername(username));
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 2, 3));



    }

    @Test
    public void userCannotLogInWithInvalidUsername() {
        sidebarPage.clickOnPractice();
        practicePage.clickOnTestLoginPage();
        for (int i = 1; i <= excelReader.getLastRow("Login"); i++) {
            invalidUsername = excelReader.getStringData("Login", i, 2);
            invalidPassword = excelReader.getStringData("Login", i, 3);
            loginPage.insertUsername(invalidUsername);
            loginPage.insertPassword(password);
            loginPage.clickOnSubmit();


        }



    }

    @Test
    public void userCannotLogInWithInvalidPassword() {
        sidebarPage.clickOnPractice();
        practicePage.clickOnTestLoginPage();
        loginPage.insertUsername(username);
        loginPage.insertPassword(invalidPassword);
        loginPage.clickOnSubmit();



    }

    @Test
    public void userCannotLogInWithInvalidPasswordAndUsername() {
        sidebarPage.clickOnPractice();
        practicePage.clickOnTestLoginPage();
        loginPage.insertUsername(invalidUsername);
        loginPage.insertPassword(invalidPassword);
        loginPage.clickOnSubmit();




    }


}
