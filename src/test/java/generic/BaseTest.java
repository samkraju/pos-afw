package generic;
//create aftermethod and before method with postcondition and precondition, open browser in pre....close browser in post

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	WebDriver driver;//create global variable
	@BeforeMethod
	public void precondition()
	{
		driver=new ChromeDriver();
	}
	@AfterMethod
	public void postcondition()
	{
		driver.quit();
	}

}
