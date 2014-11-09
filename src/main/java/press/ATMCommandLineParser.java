package press;//**Created by q on 11/8/14.

import java.util.StringTokenizer;

public class ATMCommandLineParser {

	private int winner;
	private int horseNumber;
	private int amountOfWager;
	private String message;

	ATMCommand parse(String string) {
		winner=0;
		horseNumber=0;
		amountOfWager=0;
		message="";

		if (string == null || string.length() == 0) {
			message = "no input: " + string;
			return ATMCommand.INVALID;
		}

		string = string.trim();

		if (string.toUpperCase().equals("Q")) {
			message = "quit";
			return ATMCommand.QUIT;
		}
		if (string.toUpperCase().equals("R")) {
			message = "restock";
			return ATMCommand.RESTOCK;
		}

		if (string.toUpperCase().startsWith("W")) {
			StringTokenizer stringTokenizer = new StringTokenizer(string);
			if (stringTokenizer.countTokens() == 2) {
				stringTokenizer.nextToken();
				String horseString = stringTokenizer.nextToken();
				try {
					winner = Integer.valueOf(horseString);
					if (winner<0 || winner>7) {
						message = "Invalid Horse Number: " + horseString;
						return ATMCommand.INVALID;
					}
					message="Set Winner to: " + winner;
					return ATMCommand.SETWINNER;
				} catch (NumberFormatException nfe) {
					message = "Invalid Horse Number: " + horseString;
					return ATMCommand.INVALID;
				}
			}
			message = "Invalid Command: exactly one digit token did not follow 'W'";
			return ATMCommand.INVALID;
		}

		if (Character.isDigit(string.charAt(0))) {
			StringTokenizer stringTokenizer = new StringTokenizer(string);
			if (stringTokenizer.countTokens() == 2) {
				String horseString = stringTokenizer.nextToken();
				String amountString = stringTokenizer.nextToken();
				try {
					horseNumber = Integer.valueOf(horseString);
					if (horseNumber<1 || horseNumber>7) {
						message = "Invalid Horse Number: " + horseString;
						return ATMCommand.INVALID;
					}
				} catch (NumberFormatException nfe) {
					message = "Invalid Horse Number: " + horseString;
					return ATMCommand.INVALID;
				}
				try {
					amountOfWager = Integer.valueOf(amountString);
					if (amountOfWager<=0 ) {
						message = "Invalid Bet: " + amountString;
						return ATMCommand.INVALID;
					}
				} catch (NumberFormatException nfe) {
					message = "Invalid Bet: " + amountString;
					return ATMCommand.INVALID;
				}
				message="";
				return ATMCommand.WAGER;
			}

			message = "Invalid Command: wager command must consist of exactly 2 digit tokens: " + string;
			return ATMCommand.INVALID;
		}

		message = "Invalid Command: did not recognize any command: " + string;
		return ATMCommand.INVALID;
	}

	public int getWinner() {
		return winner;
	}

	public int getHorseNumber() {
		return horseNumber;
	}

	public int getAmountOfWager() {
		return amountOfWager;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
