package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Dashboard;
import pageObjects.HomePage;
import pageObjects.ItemPage;
import pageObjects.SearchResultPage;
import pageObjects.SignIn;
import testBase.BaseClass;

public class TC_005_AddToCard extends BaseClass {

	@Test(groups = { "sanity", "master" })
	public void verify_test() {
		logger.info("*****Started TC_005_AddToCard....****");
		logger.debug("capturing application debug log..");
		try {
			HomePage hp = new HomePage(driver);
			SignIn si = new SignIn(driver);
			Dashboard d = new Dashboard(driver);
			ItemPage ip = new ItemPage(driver);
			SearchResultPage srp=new SearchResultPage(driver);

			logger.info("click on sign in button to from homepage..");
			hp.clickOnSignInButton();

			logger.info("enter email address...");
			si.setEmail(p.getProperty("email"));

			logger.info("enter passowrd..");
			si.setPassword(p.getProperty("password"));

			si.clickOnSignInButton();
			logger.info("click on sign in button...");

			logger.info("writing product name");
			d.setItemName(p.getProperty("itemName"));

			logger.info("clicking on search button");
			d.clickOnSearchButton();
			
			logger.info("click on the item");
			srp.clickOnItem();
			
			logger.info("selecting size of the item");
			ip.clickOnSelectSize();

			logger.info("selecting colore of item");
			ip.clickOnColor();

			logger.info("setting number of items");
			ip.setNumberOfitems(p.getProperty("itemCount"));

			logger.info("clicking on add to cart button");
			ip.clickOnAddtoCart();

			logger.info("validation of added successfully validation msg");
			boolean msgVerification = ip.isSuccessMessageDispalyed();
			if (msgVerification == true) {
				logger.info("added to cart msg diaplayed");
				Assert.assertTrue(true);
			} else {
				logger.error("Not adde to cart");
				Assert.fail();
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*****Ended TC_002_LoginTest....****");

	}
}
