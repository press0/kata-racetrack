package press;//**Created by q on 11/8/14.

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ATMImpl implements ATM {

	private CashInventory inventory;
	private HorseRace horseRace;

	public static void main(String[] args) throws IOException {

		ATM atm = new ATMImpl();
		Scanner scanner = new Scanner(System.in);
		ATMCommandLineParser parser = new ATMCommandLineParser();
		String scannerLine;
		boolean exit = false;
		System.out.println(atm.print());

		while (!exit && scanner.hasNextLine()) {
			scannerLine = scanner.nextLine();
			switch (parser.parse(scannerLine)) {
				case INVALID:
					break;
				case QUIT:
					exit = true;
					break;
				case RESTOCK:
					atm.restockCashInventory();
					break;
				case SETWINNER:
					atm.setHorseRaceWinner(parser.getWinner());
					break;
				case WAGER:
					int horseNumber = parser.getHorseNumber();
					int wagerAmount = parser.getAmountOfWager();
					String horseName = atm.getHorseByNumber(parser.getHorseNumber()).getName();
					int payout = parser.getAmountOfWager() * atm.getHorseByNumber(parser.getHorseNumber()).getOdds();
					HorseWagerResult horseWagerResult = atm.horseWager(horseNumber, wagerAmount);

					if (!horseWagerResult.isWin()) {
						parser.setMessage("No Payout: " + horseName);
						break;
					}

					if (!horseWagerResult.sufficientFunds()) {
						parser.setMessage("Insufficient Funds: " + payout);
						break;
					}

					StringBuilder sb = new StringBuilder();
					sb.append("Payout: " + horseName + ",$" + payout + "\n");

					sb.append("Dispensing:" + "\n");
					CashInventory cashInventory = horseWagerResult.getPayout();
					List<CashInventoryEntry> entries = cashInventory.getEntries();

					CashInventoryEntry c;
					for (int i=0; i<entries.size(); i++){
						c = entries.get(i);
						sb.append(c.getKey().string() + "," + c.getValue() + "\n");
					}

					System.out.print(sb);

					break;
			}
			System.out.println(parser.getMessage());
			System.out.println(atm.print());
		}
	}

	@Override
	public int cashHelper(CashInventory cashInventory, CashInventoryBillSize billSize) {
		return cashInventory.getByBillSize(billSize).getValue();
	}

	@Override
	public Horse getHorseByNumber(int i) {
		return horseRace.getHorseRaceEntryByNumber(i).getKey();
	}

	@Override
	public HorseWagerResult horseWager(final int horseNumber, final int amount) {
		HorseRaceEntry horseRaceEntry = horseRace.getHorseRaceEntryByNumber(horseNumber);
		boolean loss = horseRaceEntry.getValue().equals(HorseRaceResult.LOSE);
		boolean sufficientFunds = inventory.getTotal() >= amount * horseRaceEntry.getKey().getOdds();

		if (loss) {
			return new HorseWagerResult(false, sufficientFunds, null);
		}

		if (!sufficientFunds) {
			return new HorseWagerResult(true, false, null);
		}

		HorseWagerResult horseWagerResult = horseWagerUtil(amount * horseRaceEntry.getKey().getOdds());
		return horseWagerResult;

	}

	private HorseWagerResult horseWagerUtil(final int amount) {

		int hundred = inventory.getByBillSize(CashInventoryBillSize.HUNDRED).getValue();
		int twenty = inventory.getByBillSize(CashInventoryBillSize.TWENTY).getValue();
		int ten = inventory.getByBillSize(CashInventoryBillSize.TEN).getValue();
		int five = inventory.getByBillSize(CashInventoryBillSize.FIVE).getValue();
		int one = inventory.getByBillSize(CashInventoryBillSize.ONE).getValue();

		CashInventory payout = new CashInventoryImpl();
		payout.zeroCashInventory();

		//work through 100, 20, 10, 5, 1
		int amountRemaining = amount;

		while (amountRemaining >= 100 && hundred > 0 ) {
			hundred--;
			amountRemaining -= 100;
			payout.add(CashInventoryBillSize.HUNDRED);
		}
		while (amountRemaining >= 20 && twenty > 0 ) {
			twenty--;
			amountRemaining -= 20;
			payout.add(CashInventoryBillSize.TWENTY);
		}
		while (amountRemaining >= 10 && ten > 0 ) {
			ten--;
			amountRemaining -= 10;
			payout.add(CashInventoryBillSize.TEN);
		}
		while (amountRemaining >= 5 && five > 0 ) {
			five--;
			amountRemaining -= 5;
			payout.add(CashInventoryBillSize.FIVE);
		}
		while (amountRemaining >= 1 && one > 0 ) {
			one--;
			amountRemaining -= 1;
			payout.add(CashInventoryBillSize.ONE);
		}

		if (amountRemaining > 0) {
			return new HorseWagerResult(true, false, null);
		}

		inventory.getByBillSize(CashInventoryBillSize.HUNDRED).setValue(hundred);
		inventory.getByBillSize(CashInventoryBillSize.TWENTY).setValue(twenty);
		inventory.getByBillSize(CashInventoryBillSize.TEN).setValue(ten);
		inventory.getByBillSize(CashInventoryBillSize.FIVE).setValue(five);
		inventory.getByBillSize(CashInventoryBillSize.ONE).setValue(one);

		return new HorseWagerResult(true, true, payout);
	}

	@Override
	public String print() {
		StringBuilder sb = new StringBuilder();
		sb.append(inventory.print());
		sb.append(horseRace.print());

		return sb.toString();
	}

	public ATMImpl() {
		horseRace = new HorseRaceImpl();
		inventory = new CashInventoryImpl();
		inventory.restockCashInventory();
	}

	@Override
	public void setHorseRaceWinner(int i) {
		horseRace.setWinner(i);
	}

	@Override
	public void restockCashInventory() {
		inventory.restockCashInventory();
	}

}
