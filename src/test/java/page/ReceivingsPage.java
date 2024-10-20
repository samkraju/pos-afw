package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReceivingsPage {

	@FindBy(xpath="//a[@title='Receivings']")
	private WebElement receivings;
	@FindBy(id="supplier")
	private WebElement selectSupplier;
	
	public ReceivingsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickReceiving()
	{
		receivings.click();
	}
	public void clickSelectSupplier()
	{
		selectSupplier.sendKeys("D&G");
	}

}
