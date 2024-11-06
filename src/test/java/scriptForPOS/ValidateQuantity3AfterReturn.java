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
public void testQuantityAfterReturn() throws InterruptedException
{
	        // Login
			String un = Utility.readFromExcel(xlpath, "ValidLogin", 1, 0);
			String pw = Utility.readFromExcel(xlpath, "ValidLogin", 1, 1);
			LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUN(un);
			loginpage.enterPW(pw);
			loginpage.clickButton();
			
			//Receive the new item sold to new customer back
			ReceivingsPage receiving=new ReceivingsPage(driver);
			receiving.clickReceiving();
			receiving.enterItem("Perfume");
			receiving.enterQuantity("10");
			Thread.sleep(5000);
			receiving.clickFinish();
			
			//check the items quantity
			ItemsPage items=new ItemsPage(driver);
			items.clickItems();
			
			
			//Return the new item to the new supplier back
			receiving.clickReceiving();
			receiving.returnItem();
			receiving.enterItem("Perfume");
			receiving.enterReturnQuantity("-200");
			
			//receiving.enterRcvQuantity();
			receiving.clickFinish();
			
			//verify the quantity in items table
			items=new ItemsPage(driver);
			items.clickItems();
			boolean status = items.getQuantity(wait,0);
			Assert.assertTrue(status);
			
			
			

			
}
}
