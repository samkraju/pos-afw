package generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

//create after method and before method with postcondition and precondition, open browser in pre....close browser in post
//open browser enter url open respective browser , add explicit and implicit wait
//use parameters in testNG to execute on different browser
//dont forget to set @Optional to avoid NullPointerException
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	WebDriver driver;// create global variable
	WebDriverWait wait;

	@Parameters({ "browser", "grid", "gridURL" })
	@BeforeMethod
	public void precondition(@Optional("chrome") String browser, @Optional("no") String grid,
			@Optional("") String gridurl) throws MalformedURLException // grid=no is local system, else remote system
	{
		System.out.println("browser : " + browser);
		System.out.println("grid : " + grid);
		System.out.println("gridurl : " + gridurl);

		if (grid.equalsIgnoreCase("yes")) {
			URL hub = new URL(gridurl);
			if (browser.equals("chrome")) {
				ChromeOptions browserOptions = new ChromeOptions();

				driver = new RemoteWebDriver(hub, browserOptions);
			} else if (browser.equalsIgnoreCase("firefox")) {
				FirefoxOptions browserOptions = new FirefoxOptions();
				driver = new RemoteWebDriver(hub, browserOptions);
			} else {
				SafariOptions browserOptions = new SafariOptions();
				driver = new RemoteWebDriver(hub, browserOptions);
			}
		}

		else {
			if (browser.equalsIgnoreCase("chrome")) {

				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			} else {
				driver = new SafariDriver();

			}
		}

		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// implicit wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@AfterMethod
	public void postcondition() {
		driver.quit();
	}

}
