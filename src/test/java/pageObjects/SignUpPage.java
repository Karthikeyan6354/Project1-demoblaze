package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage{
	
	public SignUpPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//input[@id='sign-username']")
	private WebElement txt_Sign_Username;
	
	@FindBy (xpath="//input[@id='sign-password']")
	private WebElement txt_sign_password;
	
	@FindBy (xpath="//button[normalize-space()='Sign up']")
	private WebElement btn_SignUp;
	
	@FindBy (xpath="//div[@id='signInModal']//button[@type='button'][normalize-space()='Close']")
	private WebElement btn_close;
	
	public void set_UserName(String uname) {
		txt_Sign_Username.sendKeys(uname);
	}
	
	public void set_Password(String pwd) {
		txt_sign_password.sendKeys(pwd);
	}
	
	public void click_SignUpButton() {
		btn_SignUp.click();
	}
	
	public boolean IsSignUpbtnClickable() {
		return (btn_SignUp.isEnabled());
	}
	
	public void click_closeButton() {
		btn_close.click();
	}
	
	

}
