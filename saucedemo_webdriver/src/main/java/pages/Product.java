package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Product {

    protected WebElement product;
    private By nameLocator = By.className("inventory_item_name");
    private By priceLocator = By.className("inventory_item_price");

    public Product(WebElement product) {
        this.product = product;
    }

    public String getName() {
        return product.findElement(nameLocator).getText();
    }

    public String getPrice() {
        return product.findElement(priceLocator).getText();
    }
}
