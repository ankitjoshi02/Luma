package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BasePage{
	public SearchResultPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@alt=\"Leah Yoga Top\"]") WebElement item1;
	public WebElement getItem1() {
		return item1;
	}
	
	//Actions methods
	public void clickOnItem() {
		item1.click();
	}
	

}
