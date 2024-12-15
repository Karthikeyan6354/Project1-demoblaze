package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchasePage extends BasePage{
	
	public PurchasePage(WebDriver driver) {
		super(driver);
	}
   
	@FindBy (xpath="//input[@id='name']")
	private WebElement txt_name;
	
	@FindBy (xpath="//input[@id='country']")
	private WebElement txt_country;
	
	@FindBy (xpath="//input[@id='city']")
	private WebElement txt_city;
	
	@FindBy (xpath="//input[@id='card']")
	private WebElement txt_card;
	
	@FindBy (xpath="//input[@id='month']")
	private WebElement txt_month;
	
	@FindBy (xpath="//input[@id='year']")
	private WebElement txt_year;
	
	@FindBy (xpath="//button[text()='Purchase']")
	private WebElement btn_purchase;
	
	@FindBy (xpath="//h5[@id='orderModalLabel']")
	private WebElement msg_placeOrderpage;
	
	@FindBy (xpath="//h2[text()='Thank you for your purchase!']")
	private WebElement msg_confirmation;
	
	@FindBy (xpath="//button[text()='OK']")
	private WebElement btn_Ok;
	
	public void set_name (String name) {
		txt_name.sendKeys(name);
	}  
	
	public void set_Country (String country) {
		txt_country.sendKeys(country);
	} 
	
	public void set_city (String city) {
		txt_city.sendKeys(city);
	}  
	
	public void set_card (String card) {
		txt_card.sendKeys(card);
	} 
	
	public void set_month (String month) {
		txt_month.sendKeys(month);		
	}  
	
	public void set_year (String year) {
		txt_year.sendKeys(year);		
	}
	
	public void click_purchaseButton() {
		btn_purchase.click();
	}
	
	public boolean IsPlaceOrderPageDisplayed() {
		return msg_placeOrderpage.isDisplayed();
	}
	
	public boolean verifyUserDetailsSection() {
		return txt_name.isDisplayed() && txt_country.isDisplayed() &&
				txt_city.isDisplayed() && txt_card.isDisplayed() &&
				txt_month.isDisplayed() && txt_year.isDisplayed();
	}
	
	public boolean verifyOrderConfirmation () {
		return msg_confirmation.isDisplayed();
	}
	
	public void click_OKbutton() {
		btn_Ok.click();
	}
	  
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
