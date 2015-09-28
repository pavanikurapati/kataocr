package com.pillar.kata;

public class CharLines {
	
	public CharSequence line1;
	public CharSequence line2;
	public CharSequence line3;
	
	public CharLines(){
	  	
	}
	public CharLines(CharLine line1,CharLine line2,CharLine line3){
		this.line1=line1.getCode();
		this.line2=line2.getCode();
		this.line3 = line3.getCode();
	}

	public void setLine1(CharSequence line1) {
		this.line1 = line1;
	}
	public void setLine2(CharSequence line2) {
		this.line2 = line2;
	}
	public void setLine3(CharSequence line3) {
		this.line3 = line3;
	}

	String code;
	
	public String getCode() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(line1);
		buffer.append(line2);
		buffer.append(line3);
		return buffer.toString();
	}

}
