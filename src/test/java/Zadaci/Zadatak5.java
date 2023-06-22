package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {

        //Testirati login

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();

        String validUsername = "student";
        String validPassword = "Password123";

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(validUsername);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(validPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement title = driver.findElement(By.className("post-title"));
        String loggedInTitle = title.getText();

        String expectedTitle = "Logged In Successfully";
        Assert.assertEquals(loggedInTitle, expectedTitle);

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());

        WebElement notification = driver.findElement(By.className("has-text-align-center"));
        String expectedNotification = "Congratulations " + validUsername + ". You successfully logged in!";
        Assert.assertEquals(notification.getText(), expectedNotification);
        driver.quit();

    }
}
