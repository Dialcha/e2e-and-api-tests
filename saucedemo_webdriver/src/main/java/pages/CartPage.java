package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private By checkoutButton = By.cssSelector("button[data-test='checkout']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartFullUrl() {
        return driver.getCurrentUrl();
    }

    public List<CartPage.CartListProduct> getCartListProducts() {
        List<CartListProduct> productList = new ArrayList<>();
        List<WebElement> productElements = driver.findElements(By.className("cart_item"));

        for(WebElement productElement : productElements) {
            productList.add(new CartListProduct(productElement));
        }

        return productList;
    }

    public CheckoutStepOnePage clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
        return new CheckoutStepOnePage(driver);
    }


    public class CartListProduct extends Product{

        private By quantity = By.className("cart_quantity");

        public CartListProduct(WebElement product) {
            super(product);
        }

        public String getQuantity() { return product.findElement(quantity).getText(); }
    }
}
