package scriptForPOS;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.ItemsPage;
import page.LoginPage;
import page.ReceivingsPage;

public class ValidateQuantity3AfterReturn extends BaseTest {
@Test(priority=5)
public void testQuantityAfterReturn()
{
	        // Login
			String un = Utility.readFromExcel(xlpath, "ValidLogin", 1, 0);
			String pw = Utility.readFromExcel(xlpath, "ValidLogin", 1, 1);
			LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUN(un);
			loginpage.enterPW(pw);
			loginpage.clickButton();
			
			//Receive the new item sold to new customer back
			String itemname = Utility.readFromExcel(xlpath, "ValidateQuantity3", 2, "B");
			String receivingQuantity = Utility.readFromExcel(xlpath, "ValidateQuantity3", 2, "A");
			ReceivingsPage receiving=new ReceivingsPage(driver);
			receiving.clickReceiving();
			receiving.enterItem(itemname);
		//	Thread.sleep(2000);
			receiving.enterQuantity(receivingQuantity);
		//	Thread.sleep(5000);
			receiving.clickFinish();
			
			//check the items quantity
			ItemsPage items=new ItemsPage(driver);
			items.clickItems();
			
			
			//Return the new item to the new supplier back
			String returnQuantity = Utility.readFromExcel(xlpath, "ValidateQuantity3", 2, "C");
			receiving.clickReceiving();
			receiving.returnItem();
			receiving.enterItem(itemname);
			receiving.enterReturnQuantity(returnQuantity);
			
			//receiving.enterRcvQuantity();
			receiving.clickFinish();
			
			//verify the quantity in items table
			String expectedvalue = Utility.readFromExcel(xlpath, "ValidateQuantity3", 2, "D");
			items=new ItemsPage(driver);
			items.clickItems();
			boolean status = items.getQuantity(wait,expectedvalue);
			Assert.assertTrue(status);
			
			
			

			
}
}
