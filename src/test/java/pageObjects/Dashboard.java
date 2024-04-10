package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends BasePage{
	WebDriver driver;
	public Dashboard(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//div[@class=\"panel header\"]//span[@class=\"logged-in\"][contains(text(),'Welcome')]") private WebElement welcomemssage;
	public WebElement getWelcomemssage() {
		return welcomemssage;
	}
	public boolean isWelcomeMessageDispalyed() {
		try {
		return welcomemssage.isDisplayed();
		}
		catch(Exception e) {
			return (false);
		}
	}

}
