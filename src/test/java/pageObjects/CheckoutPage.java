package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='company']")
	private WebElement companyNameTextField;

	public WebElement getCompanyNameTextField() {
		return companyNameTextField;
	}

	@FindBy(xpath = "//input[@name='street[0]']")
	private WebElement StreetAdressFirst;

	public WebElement getStreetAdressFirst() {
		return StreetAdressFirst;
	}

	@FindBy(xpath = "//input[@name='street[1]']")
	private WebElement StreetAdressSecond;

	public WebElement getStreetAdressSecond() {
		return StreetAdressSecond;
	}

	@FindBy(xpath = "//input[@name='street[1]']")
	private WebElement StreetAdressThird;

	public WebElement getStreetAdressThird() {
		return StreetAdressThird;
	}
	
	@FindBy(xpath = "//input[@name='city']") private WebElement citytextField;

	public WebElement getCitytextField() {
		return citytextField;
	}
	
	@FindBy(xpath = "//select[@name='region_id']") private WebElement state;
	
	public WebElement getState() {
		return state;
	}
	
	@FindBy(xpath = "//input[@name='postcode']") private WebElement postalCode;

	public WebElement getPostalCode() {
		return postalCode;
	}
	
	@FindBy(xpath = "//select[@name='country_id']") private WebElement country;
	
	public WebElement getCountry() {
		return country;
	}
	@FindBy(xpath = "//input[@name='telephone']") private WebElement telephone;

	public WebElement getTelephone() {
		return telephone;
	}

	// Actions method
	public void setCompanyName(String companyName) {
		companyNameTextField.sendKeys(companyName);
	}

	public void setStreetAdressFirst(String textStreetAdressFirst) {
		StreetAdressFirst.sendKeys(textStreetAdressFirst);
	}

	public void setStreetAdressSecond(String textStreetAdressSecond) {
		StreetAdressFirst.sendKeys(textStreetAdressSecond);
	}
	
	public void setStreetAdressThird(String textStreetAdressThird) {
		StreetAdressFirst.sendKeys(textStreetAdressThird);
	}
	
	public void setCity(String cityName) {
		citytextField.sendKeys(cityName);
	}
	public void setState(String stateSelection) {
		Select dropdown=new Select(state);
		dropdown.selectByValue(stateSelection);
	}
	public void setPostalCode(String postal) {
		postalCode.sendKeys(postal);
	}
	public void setCountry(String countrySelection) {
		Select dropdown=new Select(country);
		dropdown.selectByValue(countrySelection);
	}
	public void settelephone(String mobile) {
		telephone.sendKeys(mobile);
	}
}
