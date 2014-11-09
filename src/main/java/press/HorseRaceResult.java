package press;//**Created by q on 11/8/14.

public enum HorseRaceResult {
	WIN("won"), LOSE("lost");

	String printString;

	public String getPrintString() {
		return printString;
	}

	HorseRaceResult(String printString) {
		this.printString = printString;
	}
}
