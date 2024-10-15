package page;
//create a package page and create login script based on POM for pos akshara

//on this page create the methods to login

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginPage {
	@FindBy(id = "input-username")
	private WebElement untb;
	@FindBy(id = "input-password")
	private WebElement pwtb;
	@FindBy(name = "login-button")
	private WebElement gobutton;
	@FindBy(xpath = "//div[@class='error']")
	private WebElement errMsg;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterUN(String un) {
		untb.sendKeys(un);
	}

	public void enterPW(String pw) {
		pwtb.sendKeys(pw);
	}

	public void clickButton() {
		gobutton.click();
	}

	public boolean errMsgDisplayed(WebDriverWait wait, String expectedMsg) {
		try {
			wait.until(ExpectedConditions.visibilityOf(errMsg));
//			System.out.println(errMsg);
//			String actualMsg = errMsg.getText();
//			System.out.println("Actual msg:" + actualMsg);

//			Reporter.log("PASS:err msg displyed:" + actualMsg, true);
//			return (actualMsg.equals(expectedMsg));
			Reporter.log("PASS:err msg displyed:", true);
			return true;

		} catch (Exception e) {
			Reporter.log("FAIL:err msg not displayed:", true);
			return false;
		}
	}

}
