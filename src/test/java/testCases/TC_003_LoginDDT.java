package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.Dashboard;
import pageObjects.HomePage;
import pageObjects.SignIn;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String email, String password, String exp) {
		logger.info("****Starting TC_003_LoginDDT****");
		try {
			// Home Page
			HomePage hp = new HomePage(driver);
			SignIn si = new SignIn(driver);
			Dashboard d = new Dashboard(driver);
			AccountPage ac = new AccountPage(driver);

			hp.clickOnSignInButton();

			si.setEmail(email);

			si.setPassword(password);

			si.clickOnSignInButton();

			boolean r = d.isWelcomeMessageDispalyed();

			if (exp.equalsIgnoreCase("Valid")) {
				if (r == true) {
					ac.clickOnDropdown();
					ac.clickOnSignOut();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("invalid")) {
				if (r == true) {
					ac.clickOnDropdown();
					ac.clickOnSignOut();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("****Finished TC_003_LoginDDT****");
	}
}
