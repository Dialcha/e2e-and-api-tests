package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage {

    private WebDriver driver;

    private By shoppingCartBadge = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) { this.driver = driver; }

    public String getInventoryFullUrl() {
        return driver.getCurrentUrl();
    }

    public List<InventoryProduct> getInventoryProducts() {
        List<InventoryProduct> productList = new ArrayList<>();
        List<WebElement> productElements = driver.findElements(By.cssSelector(".inventory_item"));

        for (WebElement productElement : productElements) {
            productList.add(new InventoryProduct(productElement));
        }

        return productList;
    }

    public String getShoppingCartBadgeNumber() {
        WebElement badgeElement = driver.findElement(shoppingCartBadge);
        return badgeElement.getText();
    }

    public CartPage clickShoppingCartBadge() {
        driver.findElement(shoppingCartBadge).click();
        return new CartPage(driver);
    }


    public class InventoryProduct extends Product {

        private By image = By.className("inventory_item_img");
        private By addToCartButton = By.className("btn_inventory");

        public InventoryProduct(WebElement product){
            super(product);
        }

        public WebElement getImage() {
            return product.findElement(image);
        }

        public String getAddToCartButtonText() {
            return product.findElement(addToCartButton).getText();
        }

        public void clickAddToCart() {
            product.findElement(addToCartButton).click();
        }
    }
}
