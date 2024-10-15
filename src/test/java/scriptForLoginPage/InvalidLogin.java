package scriptForLoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.LoginPage;

public class InvalidLogin extends BaseTest {
	@Test(priority = 2)
	public void testInvalidLogin() {
		//get data from excel sheet, update the sheet under data
		String un = Utility.readFromExcel(xlpath, "InvalidLogin", 1, 0);
		String pw=Utility.readFromExcel(xlpath, "InvalidLogin"	, 1, 1);
		String expectedErr=Utility.readFromExcel(xlpath, "InvalidLogin", 1, 2);
//		Steps
//		1. enter invalid username//first try manually then data driven, (getting data from external source for execution)
		LoginPage page = new LoginPage(driver);
		page.enterUN(un);
//      2. enter invalid password
		page.enterPW(pw);
//		3. click on go button
		page.clickButton();
//		4. verify that error message is displayed
		boolean result = page.errMsgDisplayed(wait, expectedErr);
		Assert.assertTrue(result);

	}

}
