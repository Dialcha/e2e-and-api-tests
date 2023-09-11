package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage {

    private WebDriver driver;
    private By firstNameField = By.cssSelector("input[data-test='firstName']");
    private By lastNameField = By.cssSelector("input[data-test='lastName']");
    private By postalCodeField = By.cssSelector("input[data-test='postalCode']");
    private By continueButton = By.cssSelector("input[data-test='continue']");

    public CheckoutStepOnePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastNameField(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setPostalCodeField(String postalCode) {
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public CheckoutStepTwoPage clickContinueButton() {
        driver.findElement(continueButton).click();
        return new CheckoutStepTwoPage(driver);
    }
}
