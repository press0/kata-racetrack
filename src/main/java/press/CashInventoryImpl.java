package press;//**Created by q on 11/8/14.

import java.util.ArrayList;
import java.util.List;

public class CashInventoryImpl implements CashInventory {

	private ArrayList<CashInventoryEntry> cashInventoryEntries;

	@Override
	public CashInventoryEntry getByBillSize(CashInventoryBillSize bill) {
		for (int i=0; i<cashInventoryEntries.size(); i++){
			if (cashInventoryEntries.get(i).getKey().equals(bill)) {
				return cashInventoryEntries.get(i);
			}
		}
		return null;
	}

	@Override
	public void add(CashInventoryBillSize bill) {
		for (int i=0; i<cashInventoryEntries.size(); i++){
			if (cashInventoryEntries.get(i).getKey().equals(bill)) {
				cashInventoryEntries.get(i).setValue(cashInventoryEntries.get(i).getValue() + 1);
			}
		}
	}

	@Override
	public List<CashInventoryEntry> getEntries() {
		return cashInventoryEntries;
	}

	@Override
	public String print() {
		StringBuilder sb = new StringBuilder();
		sb.append("Inventory:\n");

		for (int i=0; i<cashInventoryEntries.size(); i++){
			CashInventoryEntry c = cashInventoryEntries.get(i);
			sb.append(c.getKey().string() + "," + c.getValue() + "\n");
		}

		return sb.toString();
	}

	@Override
	public int getTotal() {
		int total=0;
		CashInventoryEntry cie;
		for (int i=0; i<cashInventoryEntries.size(); i++){
			cie = cashInventoryEntries.get(i);
			total += cie.getKey().amount()*cie.getValue();
		}
		return total;
	}

	@Override
	public void restockCashInventory() {
		cashInventoryEntries = new ArrayList<CashInventoryEntry>();
		cashInventoryEntries.add(new CashInventoryEntry(CashInventoryBillSize.ONE, 10));
		cashInventoryEntries.add(new CashInventoryEntry(CashInventoryBillSize.FIVE, 10));
		cashInventoryEntries.add(new CashInventoryEntry(CashInventoryBillSize.TEN, 10));
		cashInventoryEntries.add(new CashInventoryEntry(CashInventoryBillSize.TWENTY, 10));
		cashInventoryEntries.add(new CashInventoryEntry(CashInventoryBillSize.HUNDRED, 10));
	}

	@Override
	public void zeroCashInventory() {
		cashInventoryEntries = new ArrayList<CashInventoryEntry>();
		cashInventoryEntries.add(new CashInventoryEntry(CashInventoryBillSize.ONE, 0));
		cashInventoryEntries.add(new CashInventoryEntry(CashInventoryBillSize.FIVE, 0));
		cashInventoryEntries.add(new CashInventoryEntry(CashInventoryBillSize.TEN, 0));
		cashInventoryEntries.add(new CashInventoryEntry(CashInventoryBillSize.TWENTY, 0));
		cashInventoryEntries.add(new CashInventoryEntry(CashInventoryBillSize.HUNDRED, 0));
	}
}
