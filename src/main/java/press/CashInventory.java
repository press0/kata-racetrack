package press;//**Created by q on 11/8/14.

import java.util.List;

public interface CashInventory {
	void restockCashInventory();
	void zeroCashInventory();
	String print();
	int getTotal();
	CashInventoryEntry getByBillSize(CashInventoryBillSize bill);
	void add(CashInventoryBillSize bill);
	List<CashInventoryEntry> getEntries();
}
