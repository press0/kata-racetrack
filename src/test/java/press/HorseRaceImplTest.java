package press;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HorseRaceImplTest {

	HorseRace horseRace;

	@Before
	public void setUp() throws Exception {
		horseRace = new HorseRaceImpl();
	}

	@Test
	public void testSetWinner() throws Exception {
		assertTrue(horseRace.getHorseRaceEntryByNumber(1).getValue().equals(HorseRaceResult.WIN));
		horseRace.setWinner(2);
		assertFalse(horseRace.getHorseRaceEntryByNumber(1).getValue().equals(HorseRaceResult.WIN));
	}

	@Test
	public void testGetHorseRaceEntryByNumber() throws Exception {
		assertTrue(horseRace.getHorseRaceEntryByNumber(7).getKey().getNumber() == 7);
	}
}