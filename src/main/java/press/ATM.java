package press;//**Created by q on 11/8/14.

public interface ATM {
	void restockCashInventory();
	void setHorseRaceWinner(int i);
	int cashHelper(CashInventory cashInventory, CashInventoryBillSize billSize);
	Horse getHorseByNumber(int i);
	HorseWagerResult horseWager(int horseNumber, int amount);
	String print();
}
