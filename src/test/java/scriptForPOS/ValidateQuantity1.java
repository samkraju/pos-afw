package scriptForPOS;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.CustomersPage;
import page.ItemsPage;
import page.LoginPage;
import page.ReceivingsPage;
import page.SupplierPage;

public class ValidateQuantity1 extends BaseTest {
	@Test(priority = 3)
	public void testQuantity() {
		// Login
		String un = Utility.readFromExcel(xlpath, "ValidLogin", 1, 0);
		String pw = Utility.readFromExcel(xlpath, "ValidLogin", 1, 1);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUN(un);
		loginpage.enterPW(pw);
		loginpage.clickButton();

		// Create a new supplier
		SupplierPage supplierpage = new SupplierPage(driver);
		supplierpage.clickOnSupplier();
		supplierpage.clickNewSupplier();
		supplierpage.enterCompanyName("D&G");
		supplierpage.enterFN("Loveena","Sam");
		supplierpage.clickSubmit();

       //Create a new item
		ItemsPage items = new ItemsPage(driver);
		items.clickItems();
		items.clickNewItem();
		items.enterItemName("Perfume");
		items.enterCategory("Cosmetic");
		items.selectSupplier("D&G");
		items.enterWSPrice("100");
		items.enterRetailPrice("150");
		items.enterQuantity("100");
		items.enterStock("0");
		items.enterReceivingQuant("0");
		items.enterReorder("100");
		items.clickSubmit();

		// Create a new Customer
		CustomersPage customer = new CustomersPage(driver);
		customer.clickCustomerTab(wait);
		customer.clickNewCustomer();
		customer.enterFName("Eric");
		customer.enterLName("Sam");
		customer.submit();

		// Receive the new item from new supplier
		ReceivingsPage receivingsPage = new ReceivingsPage(driver);
		receivingsPage.clickReceiving();
		receivingsPage.enterItem("Perfume");
		receivingsPage.enterQuantity("100");
		receivingsPage.clickFinish();

		// Verify the received quantity in items table
		items.clickItems();
		items.searchItem("Perfume");
		boolean status = items.getQuantity(wait,200);
		Assert.assertTrue(status);

		

	}

}
