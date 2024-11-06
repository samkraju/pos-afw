package scriptForPOS;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.ItemsPage;
import page.LoginPage;
import page.ReceivingsPage;
import page.SalesPage;

public class ValidateQuantity4AfterReceiving extends BaseTest {
	@Test(priority = 6)
	public void testQuantityAfterReceiving() {
		// Login
		String un = Utility.readFromExcel(xlpath, "ValidLogin", 1, 0);
		String pw = Utility.readFromExcel(xlpath, "ValidLogin", 1, 1);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUN(un);
		loginpage.enterPW(pw);
		loginpage.clickButton();

		// Receive the existing item from existing supplier
		ReceivingsPage receivings = new ReceivingsPage(driver);
		receivings.clickReceiving();
		receivings.enterItem("Perfume");
		receivings.enterQuantity("100");
		receivings.clickFinish();

		// sell the item to existing customer
		SalesPage sales = new SalesPage(driver);
		sales.clickSales(wait);
		sales.clickItem("Perfume");
		sales.enterExistingCustomer("Eric Sam");
		sales.clickQuantity(wait, "10");
		sales.clickPayment();
		sales.clickComplete();

		// verify the items in items table
		ItemsPage items = new ItemsPage(driver);
		items.clickItems();
		boolean status = items.getQuantity(wait,90);
		Assert.assertTrue(status);

	}

}
