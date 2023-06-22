package Practice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;

    WebElement username;
    WebElement password;
    WebElement submitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsername() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
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

    public void clickOnSubmit() {
        getSubmitButton().click();
    }

}
