package com.pillar.kata.test;

import org.junit.Test;
import static org.junit.Assert.*;

import com.pillar.kata.Account;
import com.pillar.kata.AccountException;

public class TestAccount {

	@Test
	public void testAccount123456789() throws AccountException{
		Account account = new Account();
		account.setLine1("    _  _     _  _  _  _  _ ");
		account.setLine2("  | _| _||_||_ |_   ||_||_|");
		account.setLine3("  ||_  _|  | _||_|  ||_| _|");
		account.read();
		assertEquals("123456789", account.getAccountNumber());
	}
	@Test
	public void testAccount459022345() throws AccountException{
		Account account = new Account();
		account.setLine1("    _  _  _  _  _  _     _ ");
		account.setLine2("|_||_ |_|| | _| _| _||_||_ ");
		account.setLine3("  | _| _||_||_ |_  _|  | _|");
		account.read();
		assertEquals("459022345", account.getAccountNumber());
	}
	
	@Test(expected=AccountException.class)
	public void testAccountException() throws AccountException{
		Account account = new Account();
		account.setLine1("    _  _  _  _  _  _     _");
		account.setLine2("|_||_ |_|| | _| _| _||_||_ ");
		account.setLine3("  | _| _||_||_ |_  _|  | _|");
		account.read();
		assertEquals("459022345", account.getAccountNumber());
	}
}
