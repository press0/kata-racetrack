package press;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ATMCommandLineParserTest {

	ATMCommandLineParser parser;

	@Before
	public void setUp() throws Exception {
		parser = new ATMCommandLineParser();
	}

	@Test
	public void testParse_SetWinner() throws Exception {
		ATMCommand command;
		command = parser.parse("W 1");
		assertTrue(command.equals(ATMCommand.SETWINNER));
		assertTrue(parser.getMessage().equals("Set Winner to: 1"));
		assertTrue(parser.getWinner() == 1);
	}

	@Test
	public void testParse_SetWager() throws Exception {
		ATMCommand command;
		command = parser.parse("1 2");
		assertTrue(command.equals(press.ATMCommand.WAGER));
		assertTrue(parser.getMessage().equals(""));
		assertTrue(parser.getHorseNumber() == 1);
		assertTrue(parser.getAmountOfWager() == 2);
	}

}