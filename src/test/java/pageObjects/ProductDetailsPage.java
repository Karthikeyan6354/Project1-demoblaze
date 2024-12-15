package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage{
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}	

	@FindBy (xpath="//a[@class='hrefch']")
    private List<WebElement> productlinks;
	
	@FindBy (xpath="//h2[@class='name']")
	private WebElement product_name;
	
	@FindBy (xpath="//h3[@class='price-container']")
	private WebElement product_price;
	
	@FindBy (xpath="//div[@id='more-information']")
	private WebElement productInfo;
	
	@FindBy (xpath="//a[text()='Add to cart']")
	private WebElement btn_AddToCart;
	
	public void selectProduct(int index) {   	
		productlinks.get(index).click();
    }

    public int getTotalProductCount() {        
        return productlinks.size();
    }
		
    public String get_productName() {
    	return product_name.getText().trim();
    }
    
    public String get_ProductPrice() {
    	return product_price.getText().trim();
    }
    
    public boolean IsProductInfoDisplayed() {
    	return productInfo.isDisplayed();
    }
    
    public void click_AddCartButton() {
    	btn_AddToCart.click();
     }
    
    
    
    

}
