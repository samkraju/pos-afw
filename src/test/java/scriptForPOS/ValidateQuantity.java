package scriptForPOS;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.CustomersPage;
import page.ItemsPage;
import page.LoginPage;
import page.ReceivingsPage;
import page.SupplierPage;

public class ValidateQuantity extends BaseTest {
	@Test
	public void testQuantity() {
		// Login
		String un = Utility.readFromExcel(xlpath, "ValidLogin", 1, 0);
		String pw = Utility.readFromExcel(xlpath, "ValidLogin", 1, 1);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUN(un);
		loginpage.enterPW(pw);
		loginpage.clickButton();

//		Create a new supplier
		SupplierPage supplierpage = new SupplierPage(driver);
		supplierpage.clickOnSupplier();
		supplierpage.clickNewSupplier();
		supplierpage.enterCompanyName();
		supplierpage.enterFN();
		supplierpage.enterLN();
		supplierpage.clickSubmit();

//		Create a new item
		ItemsPage items = new ItemsPage(driver);
		items.clickItems();
		items.clickNewItem();
		items.enterItemName();
		items.enterCategory();
		items.selectSupplier();
		items.enterWSPrice();
		items.enterRetailPrice();
		items.enterQuantity();
		items.enterStock();
		items.enterReceivingQuant();
		items.enterReorder();
		items.clickSubmit();

//		Create a new Customer

		try {
			CustomersPage customer = new CustomersPage(driver);
			customer.clickCustomerTab();
			customer.clickNewCustomer();
			customer.enterName();
		} catch (Exception e) {
			Reporter.log("Exception occured in Customers tab", true);
			e.printStackTrace();
		}

		// Receive the new item from new supplier
		ReceivingsPage receivingsPage = new ReceivingsPage(driver);
		receivingsPage.clickReceiving();
		receivingsPage.enterItem();
		receivingsPage.enterQuantity();
		receivingsPage.clickFinish();

//		Verify the received quantity in items table
		items.clickItems();
		items.searchItem();
		items.getQuantity();

	}

}
