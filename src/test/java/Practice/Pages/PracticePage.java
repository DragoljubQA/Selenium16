package Practice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticePage {

    public WebDriver driver;

    WebElement testLoginPageButton;
    WebElement testExceptionsButton;

    public WebElement getTestLoginPageButton() {
        return driver.findElement(By.linkText("Test Login Page"));
    }

    public WebElement getTestExceptionsButton() {
        return driver.findElement(By.linkText("Test Exceptions"));
    }

    public PracticePage(WebDriver driver) {
        this.driver = driver;
    }

    //--------------------------

    public void clickOnTestLoginPage() {
        getTestLoginPageButton().click();
    }

    public void clickOnTestExceptions() {
        getTestExceptionsButton().click();
    }

}
