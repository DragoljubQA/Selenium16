package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

        //Zadatak 4)
        //Otici na google, sacekati 3 sekunde, odraditi refresh,
        // uneti u polje pretrage "youtube", sacekati 2 sekunde,
        // preko ENTER dugmeta odraditi pretragu.
        // Sacekati jos 5 sekundi i zatvorite driver

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");
        Thread.sleep(3000);
        driver.navigate().refresh();

        WebElement search = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea"));
        search.sendKeys("youtube");
        Thread.sleep(2000);

        search.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        driver.quit();


    }
}
