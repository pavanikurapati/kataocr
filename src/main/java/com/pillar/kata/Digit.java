package com.pillar.kata;

import java.util.HashMap;

public class Digit {

	private HashMap< String,String> map = new HashMap<String,String>();
	
	public Digit(){
		init();
	}

	void init(){
		map.put( " _ | ||_|","0");
		map.put( "     |  |","1");
		map.put( " _  _||_ ","2");
		map.put( " _  _| _|","3");
		map.put( "   |_|  |","4");
		map.put( " _ |_  _|","5");
		map.put( " _ |_ |_|","6");
		map.put( " _   |  |","7");
		map.put( " _ |_||_|","8");
		map.put( " _ |_| _|","9");
	}
	
	public String getNumber(String  chars) throws DigitException{
		if(!map.containsKey(chars)) throw new DigitException(chars);
		return map.get(chars);
	}

}
