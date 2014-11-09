package press;//**Created by q on 11/8/14.

public class Horse {
	private int number;
	private String name;
	private int odds;

	public Horse(int number, String name, int odds) {
		this.number = number;
		this.name = name;
		this.odds = odds;
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public int getOdds() {
		return odds;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Horse horse = (Horse) o;

		if (number != horse.number) return false;
		if (odds != horse.odds) return false;
		if (!name.equals(horse.name)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = number;
		result = 31 * result + name.hashCode();
		result = 31 * result + odds;
		return result;
	}

	@Override
	public String toString() {
		return "Horse{" +
				"number=" + number +
				", name='" + name + '\'' +
				", odds=" + odds +
				'}';
	}
}
