package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By usernameField = By.cssSelector("input[data-test='username']");
    private By passwordField = By.cssSelector("input[data-test='password']");
    private By loginButton = By.cssSelector("input[data-test='login-button']");

    public LoginPage(WebDriver driver) { this.driver = driver; }

    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public InventoryPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new InventoryPage(driver);
    }
}
