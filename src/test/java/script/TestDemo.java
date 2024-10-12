package script;

import org.testng.annotations.Test;
import org.testng.Reporter;
import generic.BaseTest;

public class TestDemo extends BaseTest {
	@Test
	public void test1() {
		Reporter.log("test1....", true);
	}

}
