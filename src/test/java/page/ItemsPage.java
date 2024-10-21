package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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
//	@FindBy(xpath = "(//a[@class='page-link'])[4]")
//	private WebElement nextpage;
//	@FindBy(xpath = "//div[text()='Item Name']")
//	private WebElement itemname;
//	@FindBy(xpath = "(//div[text()='Quantity'])[2]")
//	private WebElement quantityTab;
	@FindBy(xpath="//td[text()='pen']")
	private WebElement item;
			

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

	public void clickSubmit() {
		submit.click();
	}

//	public void getItemQuantity() {
//		System.out.println("get name");
//		String name = itemname.getText();
//		System.out.println(name);
//		try {
//			if (name.equalsIgnoreCase("pen")) {
//				String q = quantityTab.getText();
//				Reporter.log("Quantity=" + q, true);
//				if (q.equals("200")) {
//					System.out.println("Quantity has been updated successfully ");
//				} else {
//					System.out.println("Error in updating quantity ");
//				}
//			}
//		} catch (Exception e) {
//			nextpage.click();
//			if (name.equals("Perfume")) {
//				String q = quantityTab.getText();
//				Reporter.log("Quantity=" + q, true);
//				if (q.equals("200")) {
//					System.out.println("Quantity has been updated successfully ");
//				} else {
//					System.out.println("Error in updating quantity ");
//				}
//
//			}
//
//		}
	public void getQuantity()
	{
		String i = item.getText();
		System.out.println("Item name="+i);
		
	}
	}

