package com.pillar.kata.input;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;


public class Digit {

	Collection<char[]> number;

	public final char pipe='|';
	public final char underScore='_';
	public final char empty=' ';
	
	private HashMap<String, Collection<char[]>> map = new HashMap<String, Collection<char[]>>();
	
	public Digit(){
		init();
	}
	void init(){
		map.put("0", getChars0());
		map.put("1", getChars1());
		map.put("2", getChars2());
		map.put("3", getChars3());
		map.put("4", getChars4());
		map.put("5", getChars5());
		map.put("6", getChars6());
		map.put("7", getChars7());
		map.put("8", getChars8());
		map.put("9", getChars9());
	}
	
	public Collection<char[]> getNumber(String number) {
		return map.get(number);
	}
	
	public Collection<char[]> getChars1(){
		 number = Arrays.asList(new char[][]{{empty,empty,empty},
											 {empty,empty,pipe},
											 {empty,empty,pipe}
								});
		return number;

	}
	public Collection<char[]>  getChars2(){
		number = Arrays.asList(new char[][]{{empty,underScore,empty},
											 {empty,underScore,pipe},
											 {pipe,underScore,empty}
								});
		
		

		return number;
	}
		
	public Collection<char[]> getChars3(){
		number = Arrays.asList(new char[][]{{empty,underScore,empty},
											 {empty,underScore,pipe},
											 {empty,underScore,pipe}
								});
		return number;

	}
	
	public Collection<char[]>  getChars4(){
		number = Arrays.asList(new char[][]{{empty,empty,empty},
											 {pipe,underScore,pipe},
											 {empty,empty,pipe}
								});
		return number;		
	}

	public Collection<char[]>  getChars5(){
		number = Arrays.asList(new char[][]{{empty,underScore,empty},
											 {pipe,underScore,empty},
											 {empty,underScore,pipe}
								});
		return number;
	}
	
	public Collection<char[]> getChars6(){
		number = Arrays.asList(new char[][]{{empty,underScore,empty},
											 {pipe,underScore,empty},
											 {pipe,underScore,pipe}
								});
		
		return number;
	}

	public Collection<char[]>  getChars7(){
		number = Arrays.asList(new char[][]{{empty,underScore,empty},
											 {empty,empty,pipe},
											 {empty,empty,pipe}
								});
		
		return number;
	}

	public Collection<char[]>  getChars8(){
		number = Arrays.asList(new char[][]{{empty,underScore,empty},
											 {pipe,underScore,pipe},
											 {pipe,underScore,pipe}
								});
		return number;
	}

	public Collection<char[]> getChars9(){
		number = Arrays.asList(new char[][]{{empty,underScore,empty},
											 {pipe,underScore,pipe},
											 {empty,underScore,pipe}
								});
		
		return number;
	}	

	public Collection<char[]> getChars0(){
		number = Arrays.asList(new char[][]{{empty,underScore,empty},
											 {pipe,empty,pipe},
											 {pipe,underScore,pipe}
								});
		return number;
}	


}
