package SauceDemo.SaucePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Homepage {
    public WebDriver driver;

    List<WebElement> addToCart;

    WebElement title;

    public List<WebElement> getAddToCart() {
        return driver.findElements(By.id("add-to-cart-"));
    }

    public List<WebElement> getTitle() {
        return driver.findElements(By.className("inventory_item_name"));
    }

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }
}
