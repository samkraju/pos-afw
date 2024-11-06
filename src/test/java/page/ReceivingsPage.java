package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReceivingsPage {

	@FindBy(xpath = "//a[@title='Receivings']")
	private WebElement receivings;
	@FindBy(id = "item")
	private WebElement item;
	WebDriver driver;
	@FindBy(name = "quantity")
	private WebElement quantity;
	@FindBy(id = "finish_receiving_button")
	private WebElement finish;
	@FindBy(xpath = "//button[@title='Receive']")
	private WebElement returnitem;
	@FindBy(xpath="//select[@name='receiving_quantity']")
	private WebElement rcvquant;
	@FindBy(xpath="//span[@class='glyphicon glyphicon-refresh']")
	private WebElement refresh;

	public ReceivingsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void clickReceiving() {

		receivings.click();
	}

	public void enterItem(String itemname) {
		item.sendKeys(itemname);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		item.sendKeys(Keys.ARROW_DOWN);
		item.sendKeys(Keys.ENTER);

	}

	public void enterQuantity(String receivingQuantity) {
		quantity.click();
		quantity.sendKeys(Keys.BACK_SPACE);
		quantity.sendKeys(receivingQuantity);
		refresh.click();
	}

	public void clickFinish() {
		finish.click();
	}

	public void returnItem() {
//		Select select=new Select(returnitem);
//		select.selectByVisibleText(selectoption);
		returnitem.click();
		returnitem.sendKeys(Keys.ARROW_DOWN);
		returnitem.sendKeys(Keys.ENTER);
	}
	public void enterReturnQuantity(String returnQuantity)
	{
		quantity.click();
		quantity.sendKeys(Keys.BACK_SPACE);
		quantity.sendKeys(returnQuantity);
		refresh.click();
	}
//	public void enterRcvQuantity()
//	{
//		rcvquant.click();
//		rcvquant.sendKeys(Keys.ARROW_DOWN);
//		rcvquant.sendKeys(Keys.ENTER);
//		
//	}

}
