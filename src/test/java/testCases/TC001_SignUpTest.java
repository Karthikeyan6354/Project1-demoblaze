package testCases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.SignUpPage;
import testBase.BaseClass;

public class TC001_SignUpTest extends BaseClass{
	
	@Test (priority =1, groups="Sanity")
	public void validateSignUpFunction() {
		
		try {
			logger.info("*****Login Test has Started ....");
			logger.info("....Home Page....");
			HomePage hp=new HomePage(driver);
			Assert.assertEquals(true, hp.IsSignUpLinkDisplayed());
			logger.info("Sign Up link is diplayed in the homepage");
						
			Assert.assertEquals(true, hp.IsSignUpLinkClickable());
			logger.info("Sign link is clikable");
			Thread.sleep(3000);
			hp.click_signupLink();
			
			logger.info(" .........Sign Up page......");
			SignUpPage sp=new SignUpPage(driver);
			
			Assert.assertEquals(true,sp.IsSignUpbtnClickable());
			logger.info("Sign up page is visible");
			System.out.println("Sign Up functionality checked successfully");	

		}
		catch (Exception e) {
			logger.error("Test Failed....");
			logger.debug("debug loggs.....");
		    Assert.fail();
		}
	}
	
	@Test (priority=2, groups="Sanity")
	public void validSignUp() throws InterruptedException {
		
		logger.info("***validSignUp***");
		SignUpPage sp=new SignUpPage(driver);
		Thread.sleep(4000);
		sp.set_UserName(getRandomAlphabetic(5));
		sp.set_Password(getalphanumberic(5));
		
		sp.click_SignUpButton();
		Thread.sleep(3000);
		logger.info("Sign up done successfully");
		Assert.assertEquals(driver.switchTo().alert().getText(),"Sign up successful.");
				
		driver.switchTo().alert().accept();
		System.out.println("Sign up success");
		Thread.sleep(3000);
		
	}

}
