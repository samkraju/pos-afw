package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class ItemsPage {
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
	@FindBy(id = "quantity_2")
	private WebElement quantity;
	@FindBy(id = "quantity_1")
	private WebElement stock;
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submit;
	@FindBy(name = "supplier_id")
	private WebElement supplierid;
	@FindBy(id = "receiving_quantity")
	private WebElement receivingQuant;
	@FindBy(id = "reorder_level")
	private WebElement reorderLevel;
	@FindBy(xpath="//input[@type='search']")
	private WebElement search;
	@FindBy(xpath = "//td[text()='Perfume']/../td[9]")
	private WebElement quant;

	public ItemsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickItems() {
		itemsTab.click();
	}

	public void clickNewItem() {
		newItem.click();
	}

	public void enterItemName() {
		itemName.sendKeys("Perfume");
	}

	public void enterCategory() {
		category.sendKeys("Cosmetic");
	}

	public void selectSupplier() {

		Select select = new Select(supplierid);
		select.selectByVisibleText("D&G");
	}

	public void enterWSPrice() {
		wholesaleprice.clear();
		wholesaleprice.sendKeys("100");
	}

	public void enterRetailPrice() {
		retailprice.clear();
		retailprice.sendKeys("150");
	}

	public void enterQuantity() {
		quantity.clear();
		quantity.sendKeys("100");
	}

	public void enterStock() {
		stock.clear();
		stock.sendKeys("150");
	}

	public void enterReceivingQuant() {
		receivingQuant.clear();
		receivingQuant.sendKeys("100");
	}

	public void enterReorder() {
		reorderLevel.clear();
		reorderLevel.sendKeys("100");
	}

	public void clickSubmit() {
		submit.click();
	}
	public void searchItem()
	{
		search.sendKeys("Perfume");
	}

	public int getQuantity() {

		int q = Integer.parseInt(quant.getText());
		System.out.println("quanity=" + q);
		if (q == 200) {
			Reporter.log("Pass:Item qty updated:" + q, true);

		} else {
			Reporter.log("Fail:Item hasnt been updated:" + q, true);
			Assert.fail();

		}
		return q;
	}

}
