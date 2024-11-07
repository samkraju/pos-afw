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
		String suppliername = Utility.readFromExcel(xlpath, "ValidateQuantity1", 2, "A");
		String supplierfn = Utility.readFromExcel(xlpath, "ValidateQuantity1", 2, "B");
		String supplierln = Utility.readFromExcel(xlpath, "ValidateQuantity1", 2, "C");
		SupplierPage supplierpage = new SupplierPage(driver);
		supplierpage.clickOnSupplier();
		supplierpage.clickNewSupplier();
		supplierpage.enterCompanyName(suppliername);
		supplierpage.enterFN(supplierfn,supplierln);
		supplierpage.clickSubmit();

       //Create a new item
		String itemname = Utility.readFromExcel(xlpath, "ValidateQuantity1", 2, "F");
		String categoryname = Utility.readFromExcel(xlpath, "ValidateQuantity1", 2,"H" );
		suppliername = Utility.readFromExcel(xlpath, "ValidateQuantity1", 2, "A");
		String wsprice = Utility.readFromExcel(xlpath, "ValidateQuantity1", 2, "I");
		String retailvalue = Utility.readFromExcel(xlpath, "ValidateQuantity1", 2, "J");
		String quantitycount = Utility.readFromExcel(xlpath, "ValidateQuantity1",2, "K");
		String stockvalue = Utility.readFromExcel(xlpath, "ValidateQuantity1", 2, "L");
		String receivingcount = Utility.readFromExcel(xlpath, "ValidateQuantity1", 2, "M");
		String reordercount = Utility.readFromExcel(xlpath, "ValidateQuantity1", 2, "N");
		ItemsPage items = new ItemsPage(driver);
		items.clickItems();
		items.clickNewItem();
		items.enterItemName(itemname);
		items.enterCategory(categoryname);
		items.selectSupplier(suppliername);
		items.enterWSPrice(wsprice);
		items.enterRetailPrice(retailvalue);
		items.enterQuantity(quantitycount);
		items.enterStock(stockvalue);
		items.enterReceivingQuant(receivingcount);
		items.enterReorder( reordercount);
		items.clickSubmit();

		// Create a new Customer
		String fn = Utility.readFromExcel(xlpath, "ValidateQuantity1", 2, "D");
		String ln = Utility.readFromExcel(xlpath, "ValidateQuantity1", 2, "E");
		CustomersPage customer = new CustomersPage(driver);
		customer.clickCustomerTab(wait);
		customer.clickNewCustomer();
		customer.enterFName(fn);
		customer.enterLName(ln);
		customer.submit();

		// Receive the new item from new supplier
		String receivingQuantity = Utility.readFromExcel(xlpath, "ValidateQuantity1", 2, "G");
		ReceivingsPage receivingsPage = new ReceivingsPage(driver);
		receivingsPage.clickReceiving();
		receivingsPage.enterItem(itemname);
		receivingsPage.enterQuantity(receivingQuantity);
		receivingsPage.clickFinish();

		// Verify the received quantity in items table
		String expectedvalue= Utility.readFromExcel(xlpath, "ValidateQuantity1", 2, "O");
		items.clickItems();
		items.searchItem(itemname);
		boolean status = items.getQuantity(wait,expectedvalue);
		Assert.assertTrue(status);

		

	}

}
