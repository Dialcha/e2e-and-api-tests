package e2e;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import testdata.TestData;

import java.util.List;

public class BuyProductsTests extends BaseTests {

    @Test
    public void testBuyProducts() {
        loginPage.setUsername(TestData.USERNAME);
        loginPage.setPassword(TestData.PASSWORD);

        InventoryPage inventoryPage = loginPage.clickLoginButton();
        List<InventoryPage.InventoryProduct> productsInventory = inventoryPage.getInventoryProducts();
        InventoryPage.InventoryProduct firstInventoryProduct = productsInventory.get(0);
        InventoryPage.InventoryProduct secondInventoryProduct = productsInventory.get(1);


        Assert.assertTrue(inventoryPage.getInventoryFullUrl().contains(TestData.INVENTORY_PATH));
        Assert.assertEquals(productsInventory.size(), 6);
        Assert.assertEquals(inventoryPage.getShoppingCartBadgeNumber(), TestData.NULL_CART);

        Assert.assertEquals(firstInventoryProduct.getName(), TestData.SAUCE_LABS_BACKPACK);
        Assert.assertEquals(firstInventoryProduct.getPrice(), TestData.SAUCE_LABS_BACKPACK_PRICE);
        Assert.assertEquals(firstInventoryProduct.getImage().isDisplayed(), true);
        Assert.assertEquals(firstInventoryProduct.getAddToCartButtonText(), TestData.ADD_TO_CART);
        firstInventoryProduct.clickAddToCart();
        Assert.assertEquals(firstInventoryProduct.getAddToCartButtonText(), TestData.REMOVE);

        Assert.assertEquals(secondInventoryProduct.getName(), TestData.SAUCE_LABS_BIKE_LIGHT);
        Assert.assertEquals(secondInventoryProduct.getPrice(), TestData.SAUCE_LABS_BIKE_LIGHT_PRICE);
        Assert.assertEquals(secondInventoryProduct.getImage().isDisplayed(), true);
        Assert.assertEquals(secondInventoryProduct.getAddToCartButtonText(), TestData.ADD_TO_CART);
        secondInventoryProduct.clickAddToCart();
        Assert.assertEquals(secondInventoryProduct.getAddToCartButtonText(), TestData.REMOVE);

        Assert.assertEquals(inventoryPage.getShoppingCartBadgeNumber(), "2");



        CartPage cartPage = inventoryPage.clickShoppingCartBadge();
        List<CartPage.CartListProduct> cartProducts = cartPage.getCartListProducts();
        CartPage.CartListProduct firstCartProduct = cartProducts.get(0);
        CartPage.CartListProduct secondCartProduct = cartProducts.get(1);


        Assert.assertTrue(cartPage.getCartFullUrl().contains(TestData.CART_PATH));
        Assert.assertEquals(cartProducts.size(), 2);

        Assert.assertEquals(firstCartProduct.getName(), TestData.SAUCE_LABS_BACKPACK);
        Assert.assertEquals(firstCartProduct.getPrice(), TestData.SAUCE_LABS_BACKPACK_PRICE);
        Assert.assertEquals(firstCartProduct.getQuantity(), "1");

        Assert.assertEquals(secondCartProduct.getName(), TestData.SAUCE_LABS_BIKE_LIGHT);
        Assert.assertEquals(secondCartProduct.getPrice(), TestData.SAUCE_LABS_BIKE_LIGHT_PRICE);
        Assert.assertEquals(secondCartProduct.getQuantity(), "1");


        CheckoutStepOnePage checkoutStepOnePage = cartPage.clickCheckoutButton();
        checkoutStepOnePage.setFirstName(TestData.FIRST_NAME);
        checkoutStepOnePage.setLastNameField(TestData.LAST_NAME);
        checkoutStepOnePage.setPostalCodeField(TestData.ZIP_CODE);



        CheckoutStepTwoPage checkoutStepTwoPage = checkoutStepOnePage.clickContinueButton();
        List<CheckoutStepTwoPage.StepTwoProduct> stepTwoProducts = checkoutStepTwoPage.getStepTwoProducts();
        CheckoutStepTwoPage.StepTwoProduct firstStepTwoProduct = stepTwoProducts.get(0);
        CheckoutStepTwoPage.StepTwoProduct secondStepTwoProduct = stepTwoProducts.get(1);


        Assert.assertTrue(checkoutStepTwoPage.getStepTwoFullUrl() .contains(TestData.CHECKOUT_STEP_TWO_PATH));

        Assert.assertEquals(firstStepTwoProduct.getName(), TestData.SAUCE_LABS_BACKPACK);
        Assert.assertEquals(firstStepTwoProduct.getPrice(), TestData.SAUCE_LABS_BACKPACK_PRICE);
        Assert.assertEquals(firstStepTwoProduct.getQuantity(), "1");

        Assert.assertEquals(secondStepTwoProduct.getName(), TestData.SAUCE_LABS_BIKE_LIGHT);
        Assert.assertEquals(secondStepTwoProduct.getPrice(), TestData.SAUCE_LABS_BIKE_LIGHT_PRICE);
        Assert.assertEquals(secondStepTwoProduct.getQuantity(), "1");
        Assert.assertEquals(checkoutStepTwoPage.getSummarySubtotal(), TestData.SUBTOTAL_MESSAGE);
        Assert.assertEquals(checkoutStepTwoPage.getTax(), TestData.TAX_MESSAGE);
        Assert.assertEquals(checkoutStepTwoPage.getSummaryTotal(), TestData.TOTAL_MESSAGE);
        Assert.assertEquals(stepTwoProducts.size(), 2);



        CheckoutCompletePage checkoutCompletePage = checkoutStepTwoPage.clickFinishButton();

        Assert.assertEquals(checkoutCompletePage.getCheckoutStatus(), TestData.CHECKOUT_STATUS_MSG);
        Assert.assertEquals(checkoutCompletePage.getcompleteHeader(), TestData.HEADER_MESSAGE);
        Assert.assertEquals(checkoutCompletePage.getCompleteText(), TestData.ORDER_DISPATCHED_MSG);
        Assert.assertEquals(checkoutCompletePage.getBackHomeButtonText(), TestData.BACK_HOME);
        Assert.assertEquals(checkoutCompletePage.getShoppingCartBadgeNumber(), TestData.NULL_CART);
    }
}
