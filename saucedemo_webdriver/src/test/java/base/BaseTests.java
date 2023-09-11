package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;


public class BaseTests {

    private WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        goHome();
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
