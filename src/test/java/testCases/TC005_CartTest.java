package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductCategoriesPage;
import pageObjects.ProductDetailsPage;
import testBase.BaseClass;

public class TC005_CartTest extends BaseClass{
	
	@Test(priority = 1, description = "Verify Item Deletion from Cart", groups="Functional")
    public void testDeleteItemFromCart() throws InterruptedException {

        logger.info("****Navigating to Home Page******");
        HomePage hp = new HomePage(driver);
       
        logger.info("Adding Product to Cart");
        ProductDetailsPage pdp=new ProductDetailsPage(driver);
        pdp.selectProduct(2);
        pdp.click_AddCartButton();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        
        CartPage cp = new CartPage(driver);
        logger.info("Get Initial Cart Count");
        int initialCartCount = cp.get_totalCartItems();
        Assert.assertTrue(initialCartCount > 0, "Cart should have items");

        logger.info("Delete First Item");
        cp.deleteFirstItem();

        logger.info("Cart Count Reduced");
        int finalCartCount = cp.get_totalCartItems();
        Assert.assertEquals(finalCartCount, initialCartCount, "Item should be deleted from cart");
    }

    @Test(priority = 2, description = "Verify Total Price Calculation", groups="Functional")
    public void testTotalPriceCalculation() throws InterruptedException {
        
    	logger.info("****Navigating to Home Page******");
        HomePage hp = new HomePage(driver);
        hp.click_homeLink();
        
        logger.info("Adding Product to Cart");
        ProductDetailsPage pdp=new ProductDetailsPage(driver);
        pdp.selectProduct(2);
        pdp.click_AddCartButton();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();  
       
        logger.info("Navigating to Home page");
        hp.click_homeLink();
        
        ProductCategoriesPage pcp=new ProductCategoriesPage(driver);
        pdp.selectProduct(3);
        pdp.click_AddCartButton();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();  
        logger.info("Added mutliple items to cart");
        
        logger.info("Navigate to Cart");
        CartPage cp = new CartPage(driver);
        cp.Click_CartLink();

        logger.info("Total Price verification");
        Thread.sleep(3000);
        double totalPrice = cp.getTotalPrice();
        Assert.assertTrue(totalPrice > 0, "Total price should be greater than zero");
    }

    @Test(priority = 3, description = "Verify Cart Clearing", groups="Functional")
    public void testClearCart() throws InterruptedException {
    	
        logger.info("Navigate to Home Page");
        HomePage hp = new HomePage(driver);
        hp.click_homeLink();
        
        logger.info("Adding Product to Cart");
        ProductDetailsPage pdp=new ProductDetailsPage(driver);
        pdp.selectProduct(2);
        pdp.click_AddCartButton();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();  

        logger.info("Navigate to Cart page");
        CartPage cp = new CartPage(driver);
        cp.Click_CartLink();

        logger.info("Get Initial Cart Count");
        int initialCartCount = cp.get_totalCartItems();
        Assert.assertTrue(initialCartCount > 0, "Cart should have items");

        logger.info("Clear Cart");
        cp.clearCart();
        Thread.sleep(3000);
        logger.info("Verify Cart is Empty");
        int finalCartCount = cp.get_totalCartItems();
        Assert.assertEquals(finalCartCount, 0, "Cart should be empty after clearing");
    }
}
