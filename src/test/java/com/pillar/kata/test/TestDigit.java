package com.pillar.kata.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.pillar.kata.CharLine;
import com.pillar.kata.CharLines;
import com.pillar.kata.Digit;
import com.pillar.kata.DigitException;

public class TestDigit {

	static Digit digit;
	
	@BeforeClass
	public static  void init(){
		digit = new Digit();
	}
	public final static char pipe='|';
	public final static char underScore='_';
	public final static char empty=' ';
	
	@Test(expected=DigitException.class)
	public void testDigitException() throws DigitException{
		assertEquals("0", digit.getNumber( " _ | ||_"));
	}
	
	@Test
	public void testDigit0() throws DigitException{
		assertEquals("0", digit.getNumber( " _ | ||_|"));
	}

	@Test
	public void testDigit1() throws DigitException{
		assertEquals("1", digit.getNumber("     |  |"));
	}
	@Test
	public void testDigit2() throws DigitException{
		assertEquals("2", digit.getNumber(" _  _||_ "));
	}
	@Test
	public void testDigit3() throws DigitException{
		assertEquals("3", digit.getNumber(" _  _| _|"));
	}
	@Test
	public void testDigit4() throws DigitException{
		assertEquals("4", digit.getNumber("   |_|  |"));
	}
	@Test
	public void testDigit5() throws DigitException{
		assertEquals("5", digit.getNumber(" _ |_  _|"));
	}
	@Test
	public void testDigit6() throws DigitException{
		assertEquals("6", digit.getNumber(" _ |_ |_|"));
	}
	@Test
	public void testDigit7() throws DigitException{
		assertEquals("7", digit.getNumber(" _   |  |"));
	}
	@Test
	public void testDigit8() throws DigitException{
		assertEquals("8", digit.getNumber(" _ |_||_|"));
	}
	@Test
	public void testDigit9() throws DigitException{
		assertEquals("9", digit.getNumber(" _ |_| _|"));
	}

	@Test
	public void testLine6() throws DigitException{
		CharLine ln61 =new CharLine(empty,underScore,empty);
		CharLine ln62 =new CharLine(pipe,underScore,empty);
		CharLine ln63 =new CharLine(pipe,underScore,pipe);
		CharLines ch6 = new CharLines(ln61,ln62,ln63);
		assertEquals(digit.getNumber(ch6.getCode()), "6");
	}
	@Test
	public void testLine0() throws DigitException{
		CharLine ln61 =new CharLine(empty,underScore,empty);
		CharLine ln62 =new CharLine(pipe,empty,pipe);
		CharLine ln63 =new CharLine(pipe,underScore,pipe);
		CharLines ch6 = new CharLines(ln61,ln62,ln63);
		assertEquals(digit.getNumber(ch6.getCode()), "0");
	}	

}
