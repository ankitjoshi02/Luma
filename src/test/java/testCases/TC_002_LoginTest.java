package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Dashboard;
import pageObjects.HomePage;
import pageObjects.SignIn;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass 
{
	
	@Test
	public void verify_test() {
		logger.info("*****Started TC_002_LoginTest....****");
		logger.debug("capturing application debug log..");
		try {
		HomePage hp=new HomePage(driver);
		SignIn si=new SignIn(driver);
		Dashboard d=new Dashboard(driver);
		
		logger.info("click on sign in button to from homepage..");
		hp.clickOnSignInButton();
		
		logger.info("enter email address...");
		si.setEmail(p.getProperty("email"));
		
		logger.info("enter passowrd..");
		si.setPassword(p.getProperty("password"));
		
		si.clickOnSignInButton();
		logger.info("click on sign in button...");
		
		logger.info("validation the my account page...");
		boolean r = d.isWelcomeMessageDispalyed();
		if(r==true) {
			logger.info("test pass...");
			Assert.assertTrue(true);
		}
		else {
			logger.error("test fails");
			Assert.fail();
		}
	}
	catch(Exception e) {
		Assert.fail();
	}
		logger.info("*****Ended TC_002_LoginTest....****");
	}
}
