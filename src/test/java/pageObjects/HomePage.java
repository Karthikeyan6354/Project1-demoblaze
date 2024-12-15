package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
	} 
	
	@FindBy (xpath="//a[@id='nava']//img")
	private WebElement logo;
	
	@FindBy (xpath="//a[@id='signin2']")
	private WebElement link_signUp;
	
	@FindBy (xpath="//a[@id='login2']")
	private WebElement link_login;
	
	@FindBy (xpath="//a[text()='Home ']")
	private WebElement link_Home;
	
	public void click_signupLink() {
		link_signUp.click();
	}
	
	public void click_loginLink() {
		link_login.click();
	}	
	
	public boolean IsLogoDisplayed() {
		return logo.isDisplayed();
	}
	
	public boolean IsSignUpLinkDisplayed() {
		return link_signUp.isDisplayed();
	}
	
	public boolean IsSignUpLinkClickable() {
		return link_signUp.isEnabled();
	}
	
	public boolean IsLoginLinkDisplayed() {
		return link_login.isEnabled();
	}
	
	public boolean IsLoginLinkClickable() {
		return link_login.isDisplayed();
	}	
	
	public void click_homeLink() {
		link_Home.click();
	}

}
