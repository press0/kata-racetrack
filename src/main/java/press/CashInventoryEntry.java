package press;//**Created by q on 11/8/14.

import java.util.AbstractMap;

public class CashInventoryEntry extends AbstractMap.SimpleEntry<CashInventoryBillSize, Integer> {

	public CashInventoryEntry(CashInventoryBillSize key, Integer value) {
		super(key, value);
	}

}
