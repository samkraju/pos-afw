package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {
	@FindBy(xpath = "//a[@title='Customers']")
	private WebElement customerTab;
	@FindBy(xpath = "//button[@title='New Customer']")
	private WebElement newCustomer;
	@FindBy(xpath = "//div[@class='modal-body']")
	private WebElement customername;

	public CustomersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickCustomerTab() {
		customerTab.click();
	}

	public void clickNewCustomer() {
		newCustomer.click();
	}

	public void enterName() {
		customername.sendKeys("Eric");
	}

}
