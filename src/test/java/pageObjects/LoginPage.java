package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//input[@id='loginusername']")
	private WebElement txt_loginUsername;
	
	@FindBy (xpath="//input[@id='loginpassword']")
	private WebElement txt_loginPassword;
	
	@FindBy (xpath="//button[normalize-space()='Log in']")
	private WebElement btn_LogIn;		
	
	@FindBy (xpath="//a[@id='nameofuser']")
	private WebElement msg_welcome;
	
	@FindBy (xpath="//a[@id='logout2']")
	private WebElement btn_logout;
	
	public void set_loginUsername(String uname) {
		txt_loginUsername.clear();
		txt_loginUsername.sendKeys(uname);
	}
	
	public void set_loginPassword(String pwd) {
		txt_loginPassword.clear();
		txt_loginPassword.sendKeys(pwd);
	}
	
	public void click_LogInButton() {
		btn_LogIn.click();
	}
	
	public boolean IsWelcomeMessageExists() {
		return msg_welcome.isDisplayed();
	}
	
	public void click_logOutButton() {
		btn_logout.click();
	}
	
}
