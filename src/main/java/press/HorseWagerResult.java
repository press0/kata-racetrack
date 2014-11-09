package press;//**Created by q on 11/8/14.

public class HorseWagerResult {

	private boolean win;
	private boolean sufficientFunds;
	private CashInventory payout;

	public HorseWagerResult(boolean win, boolean sufficientFunds, CashInventory payout) {
		this.win = win;
		this.sufficientFunds = sufficientFunds;
		this.payout = payout;
	}

	public boolean sufficientFunds() {
		return sufficientFunds;
	}

	public boolean isWin() {
		return win;
	}

	public CashInventory getPayout() {
		return payout;
	}
}
