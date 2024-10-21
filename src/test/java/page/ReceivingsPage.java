package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReceivingsPage {

	@FindBy(xpath = "//a[@href='https://pos.aksharatraining.in/pos/public/receivings']")
	private WebElement receivings;
	@FindBy(id = "item")
	private WebElement item;
	WebDriver driver;
	@FindBy(name="quantity")
	private WebElement quantity;
	@FindBy(id="finish_receiving_button")
	private WebElement finish;
	

	public ReceivingsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void clickReceiving() {

		receivings.click();
	}

	public void enterItem() {
		item.sendKeys("Perfume");
	try	{
			Thread.sleep(2000);
		}
		catch (Exception e) {
		e.printStackTrace();
	}
		
		item.sendKeys(Keys.ARROW_DOWN);
		item.sendKeys(Keys.ENTER);

	}
	public void enterQuantity()
	{
		quantity.sendKeys("100");
	}
	
	public void clickFinish()
	{
		finish.click();
	}

}
