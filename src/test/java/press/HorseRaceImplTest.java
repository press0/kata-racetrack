package press;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HorseRaceImplTest {

    HorseRace horseRace = new HorseRaceImpl();

    //TODO:
    @BeforeEach
    public void setUp() throws Exception {
//        horseRace = new HorseRaceImpl();
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