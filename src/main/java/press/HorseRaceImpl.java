package press;//**Created by q on 11/8/14.

import java.util.ArrayList;
import java.util.List;

public class HorseRaceImpl implements HorseRace {

	private List<HorseRaceEntry> horseRaceEntries = new ArrayList<HorseRaceEntry>();

	@Override
	public void setWinner(int horseNumber) {
		for ( int i=0; i<horseRaceEntries.size(); i++) {
			if ( horseRaceEntries.get(i).getKey().getNumber() == horseNumber ) {
				horseRaceEntries.get(i).setValue(HorseRaceResult.WIN);
			} else {
				horseRaceEntries.get(i).setValue(HorseRaceResult.LOSE);
			}
		}
	}

	@Override
	public HorseRaceEntry getHorseRaceEntryByNumber(int horseNumber) {
		for ( int i=0; i<horseRaceEntries.size(); i++) {
			if ( horseRaceEntries.get(i).getKey().getNumber() == horseNumber ) {
				return horseRaceEntries.get(i);
			}
		}
		return null;
	}

	@Override
	public String print() {
		StringBuilder sb = new StringBuilder();
		sb.append("Horses:\n");
		for (HorseRaceEntry horseRaceEntry : horseRaceEntries) {
			sb.append(horseRaceEntry.getKey().getNumber());
			sb.append(",");
			sb.append(horseRaceEntry.getKey().getName());
			sb.append(",");
			sb.append(horseRaceEntry.getKey().getOdds());
			sb.append(",");
			sb.append(horseRaceEntry.getValue().getPrintString() + "\n");
		}
		return sb.toString();
	}

	public HorseRaceImpl() {
		HorseRaceEntry hre;

		hre = new HorseRaceEntry(new Horse(1, "That Darn Gray Cat", 5), HorseRaceResult.WIN);
		horseRaceEntries.add(hre);

		hre = new HorseRaceEntry(new Horse(2, "Fort Utopia", 10), HorseRaceResult.LOSE);
		horseRaceEntries.add(hre);

		hre = new HorseRaceEntry(new Horse(3, "Count Sheep", 9), HorseRaceResult.LOSE);
		horseRaceEntries.add(hre);

		hre = new HorseRaceEntry(new Horse(4, "Ms Traitour", 4), HorseRaceResult.LOSE);
		horseRaceEntries.add(hre);

		hre = new HorseRaceEntry(new Horse(5, "Real Princess", 3), HorseRaceResult.LOSE);
		horseRaceEntries.add(hre);

		hre = new HorseRaceEntry(new Horse(6, "Pa Kettle", 5), HorseRaceResult.LOSE);
		horseRaceEntries.add(hre);

		hre = new HorseRaceEntry(new Horse(7, "Gin Stinger", 6), HorseRaceResult.LOSE);
		horseRaceEntries.add(hre);

	}

}
