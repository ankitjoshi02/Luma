package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	
	@Test(groups = {"regression","master"})
	public void verify_account_registratdriver(){
		logger.info("****Starting TC_001_AccountRegistrationTest****");
		logger.debug("application logs started...");
		try {
		HomePage hp=new HomePage(driver);
		AccountRegistrationPage rg=new AccountRegistrationPage(driver);
		MyAccountPage mp=new MyAccountPage(driver);
		hp.clickOnCreateAnAccount();
		logger.info(" clicked on crate account link");
		rg.setFirstName(randomString().toUpperCase());
		logger.info("Entered first name");
		rg.setLastName(randomString().toUpperCase());
		logger.info("entered last name");
		rg.setEmailField(randomString()+"@gmail.com");
		logger.info("entered email");
		String pwd=randomAlphaNumeric();
		rg.setPassword(pwd);
		logger.info("entered password");
		rg.setConfirmPassword(pwd);
		logger.info("entered confirm password");
		rg.clickOnCreateAnAccountButton();
		logger.info("clicked on Create and account button");
		String a = mp.getConfirmationMessage();
		String confirmationmsg=mp.getConfirmationMessage();
		logger.info("Validating expected msg...");
		if(confirmationmsg.equals("Thank you for registering with Main Website Store.")) {
			logger.info("test passed");
			Assert.assertTrue(true);
		}
		else {
			logger.error("test failed");
			Assert.fail();
		}
		//Assert.assertEquals(confirmationmsg, "Thank you for registering with Main Website Store.");
		}
		catch (Exception e) {
			logger.error("test fails..");
			Assert.fail();
		}
		logger.debug("application logs ended...");
		logger.info("finished test case");
	}
}
