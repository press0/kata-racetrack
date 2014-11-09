package press;
//**Created by q on 11/8/14.

public enum CashInventoryBillSize {

	ONE(1, "$1"),	FIVE(5, "$5"), TEN(10, "$10"), TWENTY(20, "$20"), HUNDRED(100, "$100");

	private final int amount;
	private String string;
	int amount() {return amount;}
	String string() {return string;}

	CashInventoryBillSize(int amount, String string) {
		this.amount = amount;
		this.string = string;
	}
}
