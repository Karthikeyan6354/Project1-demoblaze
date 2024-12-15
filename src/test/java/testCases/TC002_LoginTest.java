package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test (groups="Sanity")
	public void Validlogin() throws InterruptedException {
		
		logger.info("********Login Test********");	
	    logger.info (".......Valid Login.......");
	    HomePage hp=new HomePage(driver);
	    Assert.assertEquals(true, hp.IsLoginLinkDisplayed());
	    logger.info("Login link is displayed");
	    Assert.assertEquals(true, hp.IsLoginLinkClickable());
	    logger.info("Login link is clickable");
	    hp.click_loginLink();	    
	    
	    logger.info(".......Login Page.....");
	    LoginPage lp=new LoginPage(driver);
	    lp.set_loginUsername(prop.getProperty("username"));
	    Thread.sleep(3000);
	    lp.set_loginPassword(prop.getProperty("password"));
	    lp.click_LogInButton();
	    Thread.sleep(3000);
	    Assert.assertEquals(true, lp.IsWelcomeMessageExists());
        
	    	
	}

}
