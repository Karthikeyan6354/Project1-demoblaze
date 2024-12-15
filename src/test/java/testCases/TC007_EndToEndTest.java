package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductCategoriesPage;
import pageObjects.ProductDetailsPage;
import pageObjects.PurchasePage;
import testBase.BaseClass;

public class TC007_EndToEndTest extends BaseClass {
	
	@Test (groups="Master")
	public void testCompleteCart() throws InterruptedException {
		
		logger.info("****End to End Test****");
		HomePage hp=new HomePage(driver);
		logger.info(".....Home Page......");
		logger.info("clicking login link");
		hp.click_loginLink();
		Thread.sleep(3000);
				
		logger.info("....Login Page......");
		LoginPage lp=new LoginPage(driver);
		lp.set_loginUsername(prop.getProperty("username"));
		Thread.sleep(3000);
		lp.set_loginPassword(prop.getProperty("password"));
		logger.info("provided login user credentials");
		logger.info("click login button");
		lp.click_LogInButton();
		
		ProductDetailsPage pdp=new ProductDetailsPage(driver);
		logger.info("....Product Details Page......");
		Thread.sleep(3000);
		pdp.selectProduct(2);
		logger.info("select product");
		Assert.assertTrue(driver.getCurrentUrl().contains("prod.html"), 
	            "Not redirected to product details page");
		pdp.click_AddCartButton();
		logger.info("added to the cart");
		Thread.sleep(3000);
        driver.switchTo().alert().accept();
		
		CartPage cp=new CartPage(driver);
		logger.info("...Cart Page....");
		cp.Click_CartLink();
		cp.Click_placeOrderButton();
		logger.info("order Placed");
		Thread.sleep(3000);
		
		logger.info("Fill order details");
		PurchasePage pp=new PurchasePage(driver);
		pp.set_name(super.getRandomAlphabetic(5));
		pp.set_Country(super.getRandomAlphabetic(5));
		pp.set_city(super.getRandomAlphabetic(5));
		pp.set_card(super.getRandomNumeric(16));
		pp.set_year(super.getRandomNumeric(4));
		pp.set_month(super.getRandomNumeric(2));
		
		logger.info("provided all the details");
		
		logger.info("Purchase and verify");
        pp.click_purchaseButton();
        Assert.assertTrue(pp.verifyOrderConfirmation(), 
            "Order confirmation failed");	
        Thread.sleep(3000);
        pp.click_OKbutton();
        
        lp.click_logOutButton();
        Thread.sleep(3000);
        Assert.assertEquals(true, hp.IsLoginLinkDisplayed());
        logger.info("End to End Test done successfully");
	}

}
