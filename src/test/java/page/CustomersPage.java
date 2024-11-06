package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomersPage {
	@FindBy(xpath = "//a[@title='Customers']/..")
	private WebElement customerTab;
	@FindBy(xpath = "//button[@title='New Customer']")
	private WebElement newCustomer;

	@FindBy(id = "first_name")
	private WebElement firstname;
	@FindBy(id = "last_name")
	private WebElement lastname;
	@FindBy(id = "submit")
	private WebElement submit;

	public CustomersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickCustomerTab(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(customerTab));
		customerTab.click();

	}

	public void clickNewCustomer() {
		newCustomer.click();
	}

	public void enterFName(String fn) {
		firstname.sendKeys(fn);
	}

	public void enterLName(String ln) {
		lastname.sendKeys(ln);
	}

	public void submit() {
		submit.click();
	}

}
