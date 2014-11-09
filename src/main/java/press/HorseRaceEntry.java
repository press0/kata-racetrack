package press;//**Created by q on 11/8/14.

import java.util.AbstractMap;

public class HorseRaceEntry extends AbstractMap.SimpleEntry<Horse, HorseRaceResult> {

	public HorseRaceEntry(Horse key, HorseRaceResult value) {
		super(key, value);
	}
}
