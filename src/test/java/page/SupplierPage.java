package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplierPage {
	@FindBy(xpath = "//a[text()='Suppliers']")
	private WebElement supplier;
	@FindBy(xpath = "//button[@title='New Supplier']")
	private WebElement newSupplier;
	@FindBy(id = "company_name_input")
	private WebElement companyName;
	@FindBy(id = "first_name")
	private WebElement firstname;
	@FindBy(id = "last_name")
	private WebElement lastname;
	@FindBy(id = "submit")
	private WebElement submit;

	public SupplierPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnSupplier() {
		supplier.click();

	}

	public void clickNewSupplier() {
		newSupplier.click();
	}

	public void enterCompanyName(String suppliername) {
		companyName.sendKeys(suppliername);
	}

	public void enterFN(String supplierfn, String supplierln) {
		firstname.sendKeys(supplierfn);
		lastname.sendKeys(supplierln);
	}

	public void clickSubmit() {
		submit.click();
	}

}
