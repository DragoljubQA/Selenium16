package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium4 {
    public static void main(String[] args) {

        //Lokatori ili Selektori
        //Nacini kako pronaci neke web elemente

        //Hijerarhija pretrage po lokatorima:
        //ID - najpouzdaniji metod, element je jedinstven, najmanje podlozan promenama
        //Name - pouzdan metod, uglavnom je jedinstven, moze biti podlozan promenama
        //Class
        //CSS
        //Xpath - Apsolutni i relativni


        //-------------

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        String apsolutniXpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea";
        String relativniXpath = "//div[1]/div[1]/div/div[2]/textarea";
        String relativniXpath2 = "//*[@id=\"APjFqb\"]";

    }
}
