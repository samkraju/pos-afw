package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class ItemsPage {
	WebDriver driver;
	@FindBy(xpath = "//a[@title='Items']")
	private WebElement itemsTab;
	@FindBy(xpath = "//button[@title='New Item']")
	private WebElement newItem;
	@FindBy(id = "name")
	private WebElement itemName;
	@FindBy(id = "category")
	private WebElement category;
	@FindBy(id = "cost_price")
	private WebElement wholesaleprice;
	@FindBy(id = "unit_price")
	private WebElement retailprice;
	@FindBy(id = "quantity_1")
	private WebElement quantity;
	@FindBy(id = "receiving_quantity")
	private WebElement stock;
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submit;
	@FindBy(name = "supplier_id")
	private WebElement supplierid;
	@FindBy(id = "receiving_quantity")
	private WebElement receivingQuant;
	@FindBy(id = "reorder_level")
	private WebElement reorderLevel;
	@FindBy(xpath = "//input[@type='search']")
	private WebElement search;
	@FindBy(xpath = "//td[text()='Perfume']/../td[9]")
	private WebElement quant;
	@FindBy(xpath = "//td[text()='Perfume']/../td[1]")
	private WebElement checkbox;
	@FindBy(id = "delete")
	private WebElement delete;

	public ItemsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickItems() {
		itemsTab.click();
	}

	public void clickNewItem() {
		newItem.click();
	}

	public void enterItemName(String itemname) {
		itemName.sendKeys(itemname);
	}

	public void enterCategory(String categoryname) {
		category.sendKeys(categoryname);
	}

	public void selectSupplier(String suppliername) {

		Select select = new Select(supplierid);
		select.selectByVisibleText(suppliername);
	}

	public void enterWSPrice(String wsprice) {
		wholesaleprice.clear();
		wholesaleprice.sendKeys(wsprice);
	}

	public void enterRetailPrice(String retailvalue) {
		retailprice.clear();
		retailprice.sendKeys(retailvalue);
	}

	public void enterQuantity(String quantitycount) {
		quantity.clear();
		quantity.sendKeys(quantitycount);
	}

	public void enterStock(String stockvalue) {
		stock.clear();
		stock.sendKeys(stockvalue);
	}

	public void enterReceivingQuant(String receivingcount) {
		receivingQuant.clear();
		receivingQuant.sendKeys(receivingcount);
	}

	public void enterReorder(String reordercount) {
		reorderLevel.clear();
		reorderLevel.sendKeys(reordercount);
	}

	public void clickSubmit() {
		submit.click();
	}

	public void searchItem(String itemname) {
		search.sendKeys(itemname);
	}

	public boolean getQuantity(WebDriverWait wait, String expectedvalue) {
		wait.until(ExpectedConditions.elementToBeClickable(quant));

		String actualvalue = quant.getText();

		try {
			System.out.println("quantity=" + actualvalue);
			if (actualvalue.equals(expectedvalue)) {
				Reporter.log("Expected value=" + expectedvalue, true);
				Reporter.log("Actual value=" + actualvalue, true);
				Reporter.log("PASS:Item qty updated:" + actualvalue, true);
				return true;

			} else {
				Reporter.log("Expected value=" + expectedvalue, true);
				Reporter.log("Actual value=" + actualvalue, true);
				Reporter.log("FAIL:Item hasnt been updated:" + actualvalue, true);
				return false;
			}

		}

		catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	public void deleteItem() {
		checkbox.click();
		delete.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

}
