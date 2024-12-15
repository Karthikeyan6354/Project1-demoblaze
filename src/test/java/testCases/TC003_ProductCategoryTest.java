package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductCategoriesPage;
import testBase.BaseClass;

    public class TC003_ProductCategoryTest extends BaseClass {
	
    @Test (priority=1, groups="Regression")
    public void ProductDetails() {    	
    	logger.info("*****TC003_ProductCategoryTest****");
    	HomePage hp=new HomePage(driver);
    	ProductCategoriesPage pip=new ProductCategoriesPage(driver);
    	Assert.assertEquals(true, hp.IsLogoDisplayed());
    	logger.info("Logo is displayed properly");
    	
        Assert.assertTrue(pip.isNavigationMenuDisplayed(), 
            "Navigation menu is not displayed");
        
        Assert.assertTrue(pip.areCategoriesDisplayed(), 
            "Categories are not displayed");
        System.out.println("Menus and categories are displayed properly");
    }

    @Test (priority=2, description="verifying the naviation menu items", groups="Regression")
    public void testVerifyNavigationMenuItems() {
    	
    	ProductCategoriesPage pip=new ProductCategoriesPage(driver);
        List<String> menuItems = pip.getNavigationMenuItems();
        
        logger.info("Expected menu items");
        String[] expectedMenuItems = {
            "Contact", "About us", "Cart", "Log in","Sign up"
        };

        logger.info("Verify each expected menu item exists");
        for (String expectedItem : expectedMenuItems) {
        Assert.assertTrue(menuItems.contains(expectedItem), 
                "Menu item " + expectedItem + " is missing"
            );
        }
    }

    @Test (priority=3, description="validating category menus")
    public void testVerifyCategoryMenuItems() {
    	ProductCategoriesPage pip=new ProductCategoriesPage(driver);
        List<String> categoryItems = pip.getCategoryMenuItems();
        
        logger.info("Expected category items");
        String[] expectedCategories = {
            "Phones", "Laptops", "Monitors"
        };

        logger.info("Verify each expected category exists");
        for (String expectedCategory : expectedCategories) {
            Assert.assertTrue(
                categoryItems.contains(expectedCategory), 
                "Category " + expectedCategory + " is missing"
            );
        }
    }
    

}
