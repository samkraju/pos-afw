package script;
//SInce we have given @Optional values and this class extends base test we can run them individually without
//having to run testNG.xml file

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import generic.BaseTest;
import generic.Utility;

public class TestDemo extends BaseTest {
	@Test
	public void test1() {
		String v = Utility.readFromExcel(xlpath, "sheet1", 0, 0);
		Reporter.log("test1...."+v, true);
	//	Assert.fail();
	}

}
