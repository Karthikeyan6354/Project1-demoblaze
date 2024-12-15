package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCategoriesPage extends BasePage{
	
	public ProductCategoriesPage(WebDriver driver) {
		super(driver);
	}
		
	@FindBy (id="navbarExample")
    private WebElement navigationMenu;
    
	@FindBy (xpath="//a[contains(@class, 'nav-link')]")
	private List<WebElement> navLinks;
	
	@FindBy (xpath="//a[@id='itemc']")
	private List<WebElement> categoryLinks;
		
	public void selectProuctCategory(int index) {        
		categoryLinks.get(index).click();        
    }

    public int getTotalCategoryCount() {        
        return categoryLinks.size();
    }
	
	public List<String> getNavigationMenuItems() {
        List<String> menuItems = new ArrayList<>();
        for (WebElement link : navLinks) {
            menuItems.add(link.getText());
        }
        return menuItems;
    }

    public List<String> getCategoryMenuItems() {
        List<String> categories = new ArrayList<>();
        for (WebElement category : categoryLinks) {
            categories.add(category.getText());
        }
        return categories;
    }

    public boolean isNavigationMenuDisplayed() {
        return navigationMenu.isDisplayed();
    }

    public boolean areCategoriesDisplayed() {
        return !categoryLinks.isEmpty() && categoryLinks.get(0).isDisplayed();
    }
}

