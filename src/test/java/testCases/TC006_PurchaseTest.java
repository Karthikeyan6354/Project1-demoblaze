package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.ProductDetailsPage;
import pageObjects.PurchasePage;
import testBase.BaseClass;

public class TC006_PurchaseTest extends BaseClass {
	
	@Test (priority=1, groups="Functional")
	public void testOrderWindowRedirection() throws InterruptedException {
        
        CartPage cp = new CartPage(driver);
        ProductDetailsPage pdp=new ProductDetailsPage(driver);

        logger.info("Add product to cart");
        pdp.selectProduct(2);
        pdp.click_AddCartButton();
        cp.Click_CartLink();        

        logger.info("Click Place Order");
        cp.Click_placeOrderButton();
        Thread.sleep(3000);        
        
        PurchasePage pp=new PurchasePage(driver);
        logger.info("Verify user details section");
        Assert.assertTrue(pp.IsPlaceOrderPageDisplayed(), 
            "User details section is not complete");
        
        logger.info("user details section");
        Assert.assertTrue(pp.verifyUserDetailsSection(), 
            "User details section is not complete");
	}    
	
	@Test (priority=2, groups="Functional")
	public void testCompleteOrderProcess () throws InterruptedException {
		
		logger.info("Fill order details");
		PurchasePage pp=new PurchasePage(driver);
		pp.set_name(super.getRandomAlphabetic(5));
		pp.set_Country(super.getRandomAlphabetic(5));
		pp.set_city(super.getRandomAlphabetic(5));
		pp.set_card(super.getRandomNumeric(16));
		pp.set_year(super.getRandomNumeric(4));
		pp.set_month(super.getRandomNumeric(2));
		
		logger.info("Purchase and verify");
        pp.click_purchaseButton();
        Assert.assertTrue(pp.verifyOrderConfirmation(), 
            "Order confirmation failed");	
        Thread.sleep(3000);
        
        pp.click_OKbutton();
	}
}
