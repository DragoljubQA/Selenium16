package Practice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    public WebDriver driver;

    WebElement logOutButton;
    WebElement notification;
    WebElement title;

    public WebElement getLogOutButton() {
        return driver.findElement(By.linkText("Log out"));
    }

    public WebElement getNotification() {
        return driver.findElement(By.className("has-text-align-center"));
    }

    public WebElement getTitle() {
        return driver.findElement(By.className("post-title"));
    }

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //---------------------

    public String getNotificationText() {
        return getNotification().getText();
    }

    public boolean notificationContainsUsername(String username) {
        if (getNotificationText().contains(username)) {
            return true;
        } else {
            return false;
        }
    }

}
