package scriptForPOS;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.ItemsPage;
import page.LoginPage;
import page.SalesPage;

public class ValidateQuantity2AfterSale extends BaseTest {
	@Test(priority = 4)
	public void testSaleQuantity() {
		// Login
		String un = Utility.readFromExcel(xlpath, "ValidLogin", 1, 0);
		String pw = Utility.readFromExcel(xlpath, "ValidLogin", 1, 1);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUN(un);
		loginpage.enterPW(pw);
		loginpage.clickButton();

		// sell the new item to new customer
		String customerfn = Utility.readFromExcel(xlpath, "ValidateQuantity2", 2, "A");
		String customerln = Utility.readFromExcel(xlpath, "ValidateQuantity2", 2, "B");
		String itemname = Utility.readFromExcel(xlpath, "ValidateQuantity2", 2, "E");
		String quantity = Utility.readFromExcel(xlpath, "ValidateQuantity2", 2, "D");
		SalesPage salespage = new SalesPage(driver);
		salespage.clickSales();
		salespage.clickNewCustomer();
		salespage.enterFName(customerfn);
		salespage.enterLName(customerln);
		salespage.clickSubmit();
		salespage.clickItem(itemname);
		salespage.clickQuantity(wait, quantity);
		salespage.clickPayment();
		salespage.clickComplete();

		// verify the quantity in items table
		String expectedvalue = Utility.readFromExcel(xlpath, "ValidateQuantity2", 2, "C");
		ItemsPage items = new ItemsPage(driver);
		items = new ItemsPage(driver);
		items.clickItems();
		boolean status = items.getQuantity(wait,expectedvalue );
		Assert.assertTrue(status);

	}

}
