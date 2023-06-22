package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Selenium10 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        List<WebElement> titles = driver.findElements(By.className("inventory_item_name"));
        for (int i = 0; i < titles.size(); i++) {
            System.out.println(titles.get(i).getText());
        }

        List<String> newTitles = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            newTitles.add(titles.get(i).getText().toLowerCase(Locale.ROOT));
        }

        List<String> newNewTitle = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            newNewTitle.add(newTitles.get(i).replace(" ", "-"));
        }

        for (int i = 0; i < newNewTitle.size(); i++) {
            System.out.println(newNewTitle.get(i));
        }

        WebElement element = driver.findElement(By.id("add-to-cart-"+newNewTitle.get(0)));
        element.click();

        //Draft


    }
}
