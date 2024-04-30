package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.Dashboard;
import pageObjects.HomePage;
import pageObjects.ItemPage;
import pageObjects.OrderSuccessPage;
import pageObjects.PaymentPage;
import pageObjects.SearchResultPage;
import pageObjects.SignIn;
import testBase.BaseClass;

public class TC_004_EndToEndCase extends BaseClass {
	@Test(groups = { "sanity", "master" })
	public void verify_endToEndScenario() {
		logger.info("*****Started TC_004_CheckOut....****");
		logger.debug("capturing application debug log..");
		try {
		HomePage hp=new HomePage(driver);
		SignIn si=new SignIn(driver);
		Dashboard d=new Dashboard(driver);
		ItemPage ip=new ItemPage(driver);
		CheckoutPage cp=new CheckoutPage(driver);
		PaymentPage pp=new PaymentPage(driver);
		OrderSuccessPage osp=new OrderSuccessPage(driver);
		SearchResultPage srp=new SearchResultPage(driver);
		
		
		logger.info("click on sign in button to from homepage..");
		hp.clickOnSignInButton();
		
		logger.info("enter email address...");
		si.setEmail(p.getProperty("email"));
		
		logger.info("enter passowrd..");
		si.setPassword(p.getProperty("password"));
		
		logger.info("click on sign in button...");
		si.clickOnSignInButton();
		
	
		///start
		
		d.clickonSearchField();
		
		logger.info("writing product name");
		d.setItemName(p.getProperty("itemName"));

		logger.info("clicking on search button");
		d.clickOnSearchButton();
		
		logger.info("click on the item");
		srp.clickOnItem();
		
		logger.info("selecting size of the item");
		ip.clickOnSelectSize();

		logger.info("selecting color of item");
		ip.clickOnColor();

		logger.info("setting number of items");
		ip.setNumberOfitems(p.getProperty("itemCount"));

		logger.info("clicking on add to cart button");
		ip.clickOnAddtoCart();
		
		logger.info("verify added to cart succcess msg dispalyed");
		ip.isSuccessMessageDispalyed();

		
		//end
		
		
		
		logger.info("click on cart button...");
		ip.clickOnCart();
		
		logger.info("click on proceed to checkout button");
		ip.clickOnProceedtoCheckout();
		
		logger.info("shipping address verify");
		cp.isDisplayedmsg();
		

		//logger.info("click on new address button");
		//cp.clickonNewAddressButton();
		
		
		logger.info("entering company name");
		cp.setCompanyName(randomString());
		
		logger.info("enter StreetAaddress 1");
		cp.setStreetAdressFirst(randomString());
		
		logger.info("enter street Address 2");
		cp.setStreetAdressSecond(randomString());
		
		logger.info("enter street address 3");
		cp.setStreetAdressThird(randomString());
		
		logger.info("enter city name");
		cp.setCity(randomString());
		
		logger.info("select state");
		cp.setState(p.getProperty("stateSelection"));
		
		logger.info("enter postalcode");
		cp.setPostalCode(randomNumber());
		
		logger.info("select country");
		cp.setCountry(p.getProperty("countrySelection"));
		
		logger.info("enter phone number");
		cp.settelephone(randomNumber());
		
		logger.info("select shipping methods");
		cp.selectShippingMethods();
		
		logger.info("click on next button");
		cp.clickOnNextButton();
		
		logger.info("click on place order button");
		pp.clickOnPlaceOrderButton();
		
		logger.info("verify succes msg");
		boolean succesFullyDone =osp.issuccessMsgDispalyed();
		if(succesFullyDone==true) {
			logger.info("test pass...");
			Assert.assertTrue(true);
		}
		else {
			logger.error("test fails");
			Assert.fail();
		}
		}
		catch (Exception e) {
			logger.error("test fails..");
			Assert.fail();
		}
		logger.debug("application logs ended...");
		logger.info("finished test case");
	}
}
