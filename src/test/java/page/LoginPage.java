package page;
//create a package page and create login script based on POM for pos akshara

//on this page create the methods to login

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id = "input-username")
	private WebElement untb;
	@FindBy(id = "input-password")
	private WebElement pwtb;
	@FindBy(name = "login-button")
	private WebElement gobutton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterUN(String un) {
		untb.sendKeys("admin");
	}

	public void enterPW(String pw) {
		pwtb.sendKeys("pointofsale");
	}

	public void clickButton() {
		gobutton.click();
	}

}
