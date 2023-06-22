package Practice.Base;

import Practice.Pages.LoginPage;
import Practice.Pages.PracticePage;
import Practice.Pages.ProfilePage;
import Practice.Pages.SidebarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public SidebarPage sidebarPage;
    public PracticePage practicePage;
    public LoginPage loginPage;
    public ProfilePage profilePage;
    public ExcelReader excelReader;
    public String homeURL;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        sidebarPage = new SidebarPage(driver);
        practicePage = new PracticePage(driver);
        profilePage = new ProfilePage(driver);
        loginPage = new LoginPage(driver);
        excelReader = new ExcelReader("src/test/java/Practice/TestData.xlsx");
        homeURL = excelReader.getStringData("URL", 2, 0);


    }

    public void waitForURL(String URL) {
        wait.until(ExpectedConditions.urlToBe(URL));
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean elementIsPresent(WebElement element) {
        boolean nonexistingElement = false;
        try {
            nonexistingElement = element.isDisplayed(); //ako jeste dispayed onda se boolean menja u true
        } catch (Exception e) {
        }
        return nonexistingElement;
    }

    public void openNewTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
    }

    public void saveImage(WebElement element) throws IOException {
        wait.until(ExpectedConditions.attributeContains(element, "src", "imgflip.com"));
        String link = element.getAttribute("src");
        URL imageURL = new URL(link);
        BufferedImage saveImage = ImageIO.read(imageURL);
        String location = "C:\\Users\\drago\\Desktop\\";
        ImageIO.write(saveImage, "png", new File(location + System.currentTimeMillis() + ".png"));
    }

    public void fluentWait() {
        //Declare and initialise a fluent wait
        FluentWait wait = new FluentWait(driver);
//Specify the timout of the wait
        wait.withTimeout(Duration.ofSeconds(10));
//Specify polling time
        wait.pollingEvery(Duration.ofMillis(500));
//Specify what exceptions to ignore
        wait.ignoring(NoSuchElementException.class);

//This is how we specify the condition to wait on.
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }



}
