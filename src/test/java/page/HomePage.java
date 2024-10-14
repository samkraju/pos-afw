package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class HomePage {
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutButton;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public boolean checkHomePageDisplay(WebDriverWait wait) {
		// if(logoutButton.isDisplayed())//instead use WebDriverWait method and put in
		// try catch to handle exception
		try {
			wait.until(ExpectedConditions.visibilityOf(logoutButton));
			Reporter.log("Pass:HomePage displayed",true);
			return true;
		} catch (Exception e) {
			Reporter.log("Fail:HomePage NOT displayed", true);
			return false;

		}
	}

}
