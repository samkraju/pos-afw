package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReceivingsPage {

	@FindBy(xpath = "//a[@title='Receivings']")
	private WebElement receivings;
	@FindBy(id = "name")
	private WebElement item;

	public ReceivingsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickReceiving() {
		receivings.click();
	}

	public void enterItem() {
		item.sendKeys("Perfume");
		Select select = new Select(item);
		select.selectByVisibleText("Perfume");

	}

}
