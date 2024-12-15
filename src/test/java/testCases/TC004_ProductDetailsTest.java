package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductCategoriesPage;
import pageObjects.ProductDetailsPage;
import testBase.BaseClass;

public class TC004_ProductDetailsTest extends BaseClass {
		
    @Test (priority=0, groups="Regression")
	public void selectProductCategory() throws InterruptedException {
    	logger.info("******TC004_ProductDetailsTest***");
		ProductCategoriesPage pcp=new ProductCategoriesPage(driver);
		System.out.println(pcp.getTotalCategoryCount());
		pcp.selectProuctCategory(0);
		Thread.sleep(3000);
	}
	
	@Test (priority=2, groups="Regression")
	public void testProductDetailsAccuracy() {
        
		ProductDetailsPage pdp=new ProductDetailsPage(driver);
        String price = pdp.get_ProductPrice();       
        logger.info("Selecting the product");
        System.out.println("Product name: "+pdp.get_productName());
        Assert.assertNotNull(price, "Product price is null");
        System.out.println("Product Price: "+pdp.get_ProductPrice());
        Assert.assertEquals(true, pdp.IsProductInfoDisplayed());
     }
	
	@Test(priority=1, groups="Regression")
	public void testProductRedirection() throws InterruptedException {
		
		ProductDetailsPage pdp=new ProductDetailsPage(driver);
        int totalProducts = pdp.getTotalProductCount();
        Assert.assertTrue(totalProducts > 0, "No products found on the homepage");
        System.out.println("Total number of products: "+totalProducts);
        
        pdp.selectProduct(2);
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("prod.html"), 
            "Not redirected to product details page");
        System.out.println("Redirected Successfully");
     }
	
	@Test (dependsOnMethods="testProductDetailsAccuracy")
	public void testAddProductToCart() throws InterruptedException {
		
		CartPage cp=new CartPage(driver);
		int initialCartCount = cp.get_totalCartItems();
		
		HomePage hp=new HomePage(driver);
		hp.click_homeLink();
		
		ProductDetailsPage pdp=new ProductDetailsPage(driver);
		pdp.selectProduct(1);	
		pdp.click_AddCartButton();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		logger.info("adding the ites to cart");
        int updatedCartCount = cp.get_totalCartItems();
        Assert.assertEquals(updatedCartCount, initialCartCount + 1, 
            "Cart item count did not increment");
        System.out.println("Items are added to the cart");
    }


}
