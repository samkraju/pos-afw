package scriptForLoginPage;
//Create a test method to login and also change the url in properties file

import org.testng.Assert;

//dont forget to mention the priority

import org.testng.annotations.Test;
import generic.BaseTest;
import page.HomePage;
import page.LoginPage;

public class ValidLogin extends BaseTest {
	@Test(priority = 1) // priority will be based on manual test cases flow of execution
	public void testValidLogin() {
		LoginPage loginpage = new LoginPage(driver);
//Enter the steps as per manual test case
//	Steps
//	1. enter valid userName
		loginpage.enterUN("admin");

//	2. enter valid password
		loginpage.enterPW("pointofsale");
//	3. click go button
		loginpage.clickButton();

//	4. verify that home page is displayed
		HomePage page = new HomePage(driver);
		boolean result = page.checkHomePageDisplay(wait);

		Assert.assertTrue(result);

	}

}
