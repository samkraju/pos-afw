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
		String itemname = Utility.readFromExcel(xlpath, "ValidateQuantity4", 2, "B");
		String receivingQuantity = Utility.readFromExcel(xlpath, "ValidateQuantity4", 2, "A");
		ReceivingsPage receivings = new ReceivingsPage(driver);
		receivings.clickReceiving();
		receivings.enterItem(itemname);
		receivings.enterQuantity(receivingQuantity);
		receivings.clickFinish();

		// sell the item to existing customer
		String existingcustomerfullname=Utility.readFromExcel(xlpath, "ValidateQuantity4", 2, "C");
		String salequant=Utility.readFromExcel(xlpath, "ValidateQuantity4", 2, "D");
		SalesPage sales = new SalesPage(driver);
		sales.clickSales();
		sales.clickItem(itemname);
		sales.enterExistingCustomer(existingcustomerfullname);
		sales.clickQuantity(wait, salequant);
		sales.clickPayment();
		sales.clickComplete();

		// verify the items in items table
		String	expectedvalue=Utility.readFromExcel(xlpath, "ValidateQuantity4", 2, "E");
		ItemsPage items = new ItemsPage(driver);
		items.clickItems();
		boolean status = items.getQuantity(wait,expectedvalue);
		Assert.assertTrue(status);

	}

}
