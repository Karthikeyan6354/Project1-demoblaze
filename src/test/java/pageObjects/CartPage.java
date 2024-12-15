package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
	
	public CartPage (WebDriver driver) {
		super(driver);
	}
    
	@FindBy (xpath="//a[text()='Cart']")
	private WebElement link_cart;
	
	@FindBy (xpath="//tr[@class='success']")
	private List<WebElement> cartItems;
	
	@FindBy (xpath="//h3[@id='totalp']")
	private WebElement totalPrice;
	
	@FindBy (xpath="//a[text()='Delete']")
	private List<WebElement> deleteButtons;
	
	@FindBy (xpath="//button[text()='Place Order']")
	private WebElement btn_placeOrder;
	
	public int get_totalCartItems() {
		Click_CartLink();
		return cartItems.size();
	}
	
	public void Click_CartLink() {
		link_cart.click();
	}
	
	public double getTotalPrice() {
        String priceText = totalPrice.getText();
        return Double.parseDouble(priceText);
    }

    public void deleteFirstItem() {
        
        if (!deleteButtons.isEmpty()) {
            deleteButtons.get(0).click();
        }
    }

    public void clearCart() throws InterruptedException {
        while (get_totalCartItems() > 0) {
        	deleteFirstItem();
        	Thread.sleep(3000);
        }    
    } 
    
    public void Click_placeOrderButton() {
    	btn_placeOrder.click();
    }
	
}
