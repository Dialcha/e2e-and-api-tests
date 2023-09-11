package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage {

    private WebDriver driver;

    private By checkoutStatus = By.className("title");
    private By completeHeader = By.className("complete-header");
    private By completeText = By.className("complete-text");
    private By backHomeButton = By.cssSelector("button[data-test='back-to-products']");
    private By shoppingCartBadge = By.className("shopping_cart_link");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCheckoutStatus(){
        WebElement checkoutStatusElement = driver.findElement(checkoutStatus);
        return checkoutStatusElement.getText();
    }

    public String getcompleteHeader(){
        WebElement completeHeaderElement = driver.findElement(completeHeader);
        return completeHeaderElement.getText();
    }

    public String getCompleteText(){
        WebElement completeTextElement = driver.findElement(completeText);
        return completeTextElement.getText();
    }

    public String getBackHomeButtonText(){
        WebElement backHomeButtonElement = driver.findElement(backHomeButton);
        return backHomeButtonElement.getText();
    }

    public String getShoppingCartBadgeNumber() {
        WebElement badgeElement = driver.findElement(shoppingCartBadge);
        return badgeElement.getText();
    }
}
