package com.pillar.kata.input;

import java.util.Collection;
import java.util.Iterator;

public class CharLines {

	public String getLine1() {
		return line1;
	}

	public String getLine2() {
		return line2;
	}

	public String getLine3() {
		return line3;
	}



	String line1=null;
	String line2=null;
	String line3=null;

	
	public CharLines(Collection<char[]> number){
		try{
		Iterator<char[]> it = number.iterator();
		for(int i =0;it.hasNext();i++){
			char[] o =(char[])it.next();
			
			switch(i){
				case 0: line1= String.valueOf(o);break;
				case 1: line2= String.valueOf(o);break;
				case 2: line3= String.valueOf(o);break;
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}
