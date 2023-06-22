package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak2 {
    public static void main(String[] args) {

        //Zadatak 2
//Otvoriti browser i jos 5 tabova
//Na svakom tabu otvoriti URL po zelji
//Zatvoriti sve tabove osim onog gde je otvoren Google

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 5; i++) {
            js.executeScript("window.open()");
        }

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(listaTabova.get(0));
        driver.get("https://www.google.com/");

        driver.switchTo().window(listaTabova.get(1));
        driver.get("https://www.youtube.com/");

        driver.switchTo().window(listaTabova.get(2));
        driver.get("https://www.linkedin.com/");

        driver.switchTo().window(listaTabova.get(3));
        driver.get("https://www.joberty.rs/");

        driver.switchTo().window(listaTabova.get(4));
        driver.get("https://www.linkedin.com/");

        driver.switchTo().window(listaTabova.get(5));
        driver.get("https://www.joberty.com/");

        //--------------------

        /*driver.switchTo().window(listaTabova.get(1));
        driver.close();
        driver.switchTo().window(listaTabova.get(2));
        driver.close();
        driver.switchTo().window(listaTabova.get(3));
        driver.close();
        driver.switchTo().window(listaTabova.get(4));
        driver.close();
        driver.switchTo().window(listaTabova.get(5));
        driver.close();*/

        //Drugi nacin
        /*for (int i = 1; i < 6 ; i++) {
            driver.switchTo().window(listaTabova.get(i));
            driver.close();
        }*/

        for (int i = 0; i < listaTabova.size(); i++) {
            driver.switchTo().window(listaTabova.get(i));
            if (!driver.getCurrentUrl().equals("https://www.google.com/")) {
                driver.close();
            }
        }

    }
}
