package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submit;

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

	public void clickSubmit() {
		submit.click();
	}
}
