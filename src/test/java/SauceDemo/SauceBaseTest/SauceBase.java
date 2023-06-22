package SauceDemo.SauceBaseTest;

import SauceDemo.SaucePages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class SauceBase {
    public WebDriver driver;
    public LoginPage loginPage;
    public ExcelReader excelReader;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        excelReader = new ExcelReader("C:\\Users\\drago\\Desktop\\TestData.xlsx");
    }

    @AfterClass
    public void tearDown() {

    }

}
