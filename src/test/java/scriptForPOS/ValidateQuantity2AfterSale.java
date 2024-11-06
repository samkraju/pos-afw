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
		SalesPage salespage = new SalesPage(driver);
		salespage.clickSales(wait);
		salespage.clickNewCustomer();
		salespage.enterName("Aiden", "Sam");
		salespage.clickSubmit();
		salespage.clickItem("Perfume");
		salespage.clickQuantity(wait, "10");
		salespage.clickPayment();
		salespage.clickComplete();

		// verify the quantity in items table
		ItemsPage items = new ItemsPage(driver);
		items = new ItemsPage(driver);
		items.clickItems();
		boolean status = items.getQuantity(wait, 190);
		Assert.assertTrue(status);

	}

}
