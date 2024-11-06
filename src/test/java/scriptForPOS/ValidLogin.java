package scriptForPOS;
//Create a test method to login and also change the url in properties file

import org.testng.Assert;

//dont forget to mention the priority

import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Utility;
import page.HomePage;
import page.LoginPage;

public class ValidLogin extends BaseTest {
	@Test(priority = 2) // priority will be based on manual test cases flow of execution
	public void testValidLogin() {
		String un=Utility.readFromExcel(xlpath, "ValidLogin", 1, 0);
		String pw=Utility.readFromExcel(xlpath, "ValidLogin", 1, 1);
		LoginPage loginpage = new LoginPage(driver);
//Enter the steps as per manual test case

//	1. enter valid userName
		loginpage.enterUN(un);

//	2. enter valid password
		loginpage.enterPW(pw);
//	3. click go button
		loginpage.clickButton();

//	4. verify that home page is displayed
		HomePage page = new HomePage(driver);
		boolean result = page.checkHomePageDisplay(wait);

		Assert.assertTrue(result);

	}

}
