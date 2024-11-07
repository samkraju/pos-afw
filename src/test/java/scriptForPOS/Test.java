package scriptForPOS;

import generic.Utility;

public class Test {

	public static void main(String[] args) {
		System.out.println(Utility.readFromExcel("./data/input.xlsx", "ValidateQuantity1", 2, "L"));
	}
}
