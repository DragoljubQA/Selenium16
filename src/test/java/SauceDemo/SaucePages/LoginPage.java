package SauceDemo.SaucePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    WebElement username;
    WebElement password;
    WebElement submit;

    public WebElement getUsername() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getSubmit() {
        return driver.findElement(By.id("login-button"));
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //---------------------------

    public void insertUsername(String username) {
        getUsername().clear();
        getUsername().sendKeys(username);
    }

    public void insertPassword(String password) {
        getPassword().clear();
        getPassword().sendKeys(password);
    }

    public void clickOnLogin() {
        getSubmit().click();
    }

}
