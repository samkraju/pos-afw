package scriptForLoginPage;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.ItemsPage;
import page.LoginPage;
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
		ItemsPage items=new ItemsPage(driver);
		items.clickItems();
		items.clickNewItem();
		items.enterItemName();
		items.enterCategory();
		items.enterWSPrice();
		items.enterRetailPrice();
		items.enterQuantity();
		items.enterStock();
		items.clickSubmit();
//		Create a new Customer
//		Receive the new item from new supplier

//		verify the received quantity in items table
	}

}
