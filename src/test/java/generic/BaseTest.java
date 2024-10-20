package generic;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//create after method and before method with postcondition and precondition, open browser in pre....close browser in post
//open browser enter url open respective browser , add explicit and implicit wait
//use parameters in testNG to execute on different browser
//dont forget to set @Optional to avoid NullPointerException
//copy all the public static final variables into an interface

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConstants {
	
	public WebDriver driver;// create global variable
	public WebDriverWait wait;

	@Parameters({ "browser", "grid", "gridURL","env" })
	@BeforeMethod
	public void precondition(@Optional(DEFAULTBROWSER) String browser, @Optional(DEFAULTGRID) String grid,
			@Optional(DEFAULTGRIDURL) String gridurl,@Optional(DEFAULTENV)String env) throws MalformedURLException // grid=no is local system, else remote system
	{
		System.out.println("browser : " + browser);
		System.out.println("grid : " + grid);
		System.out.println("gridurl : " + gridurl);

		if (grid.equalsIgnoreCase("yes")) {
			URL hub = new URL(gridurl);
			if (browser.equals("chrome")) {
				ChromeOptions browserOptions = new ChromeOptions();
				Reporter.log("Open the browser", true);
				driver = new RemoteWebDriver(hub, browserOptions);
				Reporter.log("Opening Chrome on remote system", true);
			} else if (browser.equalsIgnoreCase("firefox")) {
				FirefoxOptions browserOptions = new FirefoxOptions();
				Reporter.log("Open the browser", true);
				driver = new RemoteWebDriver(hub, browserOptions);
				Reporter.log("Opening Firefox on remote system", true);
			} else {
				SafariOptions browserOptions = new SafariOptions();
				Reporter.log("Open the browser", true);
				driver = new RemoteWebDriver(hub, browserOptions);
				Reporter.log("Opening Safari on remote system", true);
			}
		}

		else {
			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				Reporter.log("Opening chrome on local system", true);

			} else if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				Reporter.log("Opening firefox on local system", true);

			} else {
				driver = new SafariDriver();
				Reporter.log("Opening Safari on local system", true);

			}
		}

		driver.manage().window().maximize();
		Reporter.log("Maximize the browser", true);

		String appurl = Utility.getDatafromProperty(env, "Appurl");
		System.out.println(appurl);
		driver.get(appurl);
		Reporter.log("Enter the URL", true);

		String ito = Utility.getDatafromProperty(env, "ITO");
		int time = Integer.parseInt(ito);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));// implicit wait
		Reporter.log("Implicit wait", true);

		int eto = Integer.parseInt(Utility.getDatafromProperty(env, "ETO"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(eto));
		Reporter.log("Explicit wait", true);
	}

	@AfterMethod
	public void postcondition(ITestResult testResult) throws IOException, InterruptedException {
		String name = testResult.getName();
		int status = testResult.getStatus();
		if (status == 2) {
			TakesScreenshot t = (TakesScreenshot) driver;
			File src = t.getScreenshotAs(OutputType.FILE);// src as png
			String path = SCREENSHOT + name + ".png";
			File dst = new File(path);
			FileUtils.copyFile(src, dst);
			Reporter.log(name + " has failed,hence screenshot has been taken", true);

		} else {
			Reporter.log(name + " has passed,hence NO screenshot has been taken", true);
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
