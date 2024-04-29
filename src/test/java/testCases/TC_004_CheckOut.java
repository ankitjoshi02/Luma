package testCases;

import org.testng.annotations.Test;

import pageObjects.Dashboard;
import pageObjects.HomePage;
import pageObjects.ItemPage;
import pageObjects.SignIn;
import testBase.BaseClass;

public class TC_004_CheckOut extends BaseClass {
	@Test(groups = {"sanity","master"})
	public void verify_test() {
		logger.info("*****Started TC_004_CheckOut....****");
		logger.debug("capturing application debug log..");
		
		HomePage hp=new HomePage(driver);
		SignIn si=new SignIn(driver);
		Dashboard d=new Dashboard(driver);
		ItemPage ip=new ItemPage(driver);
		
		logger.info("click on sign in button to from homepage..");
		hp.clickOnSignInButton();
		
		logger.info("enter email address...");
		si.setEmail(p.getProperty("email"));
		
		logger.info("enter passowrd..");
		si.setPassword(p.getProperty("password"));
		
		si.clickOnSignInButton();
		logger.info("click on sign in button...");
		
		logger.info("click on cart button...");
		ip.clickOnCart();
		
		logger.info("click on proceed to checkout button");
		ip.clickOnProceedtoCheckout();
		
	}
}
