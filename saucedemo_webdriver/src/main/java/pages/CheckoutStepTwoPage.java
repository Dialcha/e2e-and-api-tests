package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckoutStepTwoPage {

    private WebDriver driver;
    private By finishButton = By.cssSelector("button[data-test='finish']");
    private By summarySubtotalLabel = By.className("summary_subtotal_label");
    private By summaryTotalLabel = By.className("summary_total_label");
    private By summaryTaxLabel = By.className("summary_tax_label");

    public CheckoutStepTwoPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSummarySubtotal(){
        WebElement summarySubtotalElement = driver.findElement(summarySubtotalLabel);
        return summarySubtotalElement.getText();
    }

    public String getSummaryTotal(){
        WebElement summaryTotal = driver.findElement(summaryTotalLabel);
        return summaryTotal.getText();
    }

    public String getTax(){
        WebElement summaryTax = driver.findElement(summaryTaxLabel);
        return summaryTax.getText();
    }

    public String getStepTwoFullUrl() {
        return driver.getCurrentUrl();
    }

    public CheckoutCompletePage clickFinishButton() {
        driver.findElement(finishButton).click();
        return new CheckoutCompletePage(driver);
    }

    public List<StepTwoProduct> getStepTwoProducts() {
        List<StepTwoProduct> productList = new ArrayList<>();
        List<WebElement> productElements = driver.findElements(By.className("cart_item"));

        for(WebElement productElement : productElements) {
            productList.add(new StepTwoProduct(productElement));
        }

        return productList;
    }


    public class StepTwoProduct extends Product {

        private By quantity = By.className("cart_quantity");

        public StepTwoProduct(WebElement product) {
            super(product);
        }

        public String getQuantity() { return product.findElement(quantity).getText(); }
    }
}
