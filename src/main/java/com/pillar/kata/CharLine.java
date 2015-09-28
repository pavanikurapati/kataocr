package com.pillar.kata;

public class CharLine {

	public CharLine(String chars){
		this.code = chars;
	}
	public CharLine(char first,char second, char third){
		StringBuffer buffer = new StringBuffer();
		this.code = buffer.append(first).append(second).append(third).toString();
	}
	public CharLine(CharSequence threeChars){
		code = threeChars.toString();
	}
	String code;
	public String getCode() {
		return code;
	}

}
