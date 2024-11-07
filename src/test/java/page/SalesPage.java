package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesPage {
	@FindBy(xpath = "//a[@title='Sales']")
	private WebElement sales;
	@FindBy(id = "item")
	private WebElement item;
	@FindBy(xpath = "//input[@name='quantity']")
	private WebElement quantity;
	@FindBy(xpath = "//button[@title='New Customer']")
	private WebElement newCustomer;
	@FindBy(id = "first_name")
	private WebElement firstname;
	@FindBy(id = "last_name")
	private WebElement lastname;
	@FindBy(id = "submit")
	private WebElement submit;
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-refresh']")
	private WebElement refresh;
	@FindBy(id = "add_payment_button")
	private WebElement payment;
	@FindBy(id = "finish_sale_button")
	private WebElement complete;
	@FindBy(name = "customer")
	private WebElement existingcustomername;

	// initialization--constructor should be public
	public SalesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization using getter/setters
	public void clickSales() {

		sales.click();
	}

	public void clickNewCustomer() {

		newCustomer.click();
	}

	public void enterFName(String customerfn) {
		firstname.sendKeys(customerfn);

	}

	public void enterLName(String customerln) {
		lastname.sendKeys(customerln);
	}

	public void clickSubmit() {
		submit.click();
	}

	public void clickItem(String itemname) {

		try {
			Thread.sleep(2000);
			item.sendKeys(itemname);
			Thread.sleep(2000);
			item.sendKeys(Keys.ARROW_DOWN);
			item.sendKeys(Keys.ENTER);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickQuantity(WebDriverWait wait, String salequant) {

		wait.until(ExpectedConditions.elementToBeClickable(quantity));
		quantity.sendKeys(Keys.BACK_SPACE);
		quantity.sendKeys(salequant);
		refresh.click();
	}

	public void enterExistingCustomer(String existingcustomerfullname) {
		existingcustomername.sendKeys(existingcustomerfullname);
		existingcustomername.sendKeys(Keys.ARROW_DOWN);
		existingcustomername.sendKeys(Keys.ENTER);
	}

	public void clickPayment() {
		payment.click();
	}

	public void clickComplete() {
		complete.click();
	}

}
