package com.pillar.kata;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Account {

	private final static Logger logger = Logger.getLogger(Account.class
			.getName());
	String line1;
	String line2;
	String line3;

	public Account() {
		digit = new Digit();
		accountNumber = new StringBuffer();

	}

	public void setLine1(String line1) {
		;
		this.line1 = line1;
	}

	public void setLine2(String line2) {

		this.line2 = line2;
	}

	public void setLine3(String line3) {

		this.line3 = line3;
	}

	private Digit digit;

	private StringBuffer accountNumber;

	public String getAccountNumber() {
		return accountNumber.toString();
	}

	public void read() throws AccountException {
		accountNumber = new StringBuffer();
		CharLines characterLines = new CharLines();
		try {
			for (int i = 0; i < 9; i++) {
				characterLines = new CharLines();
				characterLines.setLine1(line1.subSequence((3 * i),
						(3 * (i + 1))));
				characterLines.setLine2(line2.subSequence((3 * i),
						(3 * (i + 1))));
				characterLines.setLine3(line3.subSequence((3 * i),
						(3 * (i + 1))));
				accountNumber.append(digit.getNumber(characterLines.getCode()));
			}
		} catch (IndexOutOfBoundsException indexException) {
			String error = "length line1=" + line1.length() + " line2 = "
					+ line2.length() + " line3 = " + line3.length();
			throw new AccountException(error);
		} catch (DigitException digitException) {

			logger.log(Level.SEVERE, digitException.getMessage(),
					digitException);
			String error = "Due to Invalid digit";
			throw new AccountException(error);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.log(Level.INFO, "Account Number " + accountNumber.toString());
	}

}
