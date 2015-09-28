package com.pillar.kata.input;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Account {
	PrintWriter pw;
	Digit d;
	String accountNumber ;
	List<CharLines> lines;

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public Account(String accountNumber){
		this.accountNumber = accountNumber;
		try{
			pw = new PrintWriter("ocr.txt");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void print(){
		lines = new ArrayList<CharLines>();
		d= new Digit();
		for(int i=0;i<accountNumber.length();i++){
			try{
					String t=accountNumber.substring(i,i+1);
					CharLines cl = new CharLines(d.getNumber(t));
					lines.add(cl);
				}catch(Exception e){
				System.out.println(i);
				e.printStackTrace();
			}
		}
		StringBuffer lb1 = new StringBuffer();
		StringBuffer lb2 = new StringBuffer();
		StringBuffer lb3 = new StringBuffer();
		for(CharLines cl : lines){
			lb1.append(cl.getLine1());
			lb2.append(cl.getLine2());
			lb3.append(cl.getLine3());
		}
		pw.println(lb1.toString());
		pw.println(lb2.toString());
		pw.println(lb3.toString());
		System.out.println(lb1.toString());
		System.out.println(lb2.toString());
		System.out.println(lb3.toString());
		pw.println();
	}
	public void close(){
		try{
			pw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void write(){
		
		CharLines cl = new CharLines(d.getNumber("1"));

		CharLines c3 = new CharLines(d.getNumber("3"));
		CharLines c4 = new CharLines(d.getNumber("2"));

		System.out.println(cl.getLine1()+c3.getLine1()+c4.getLine1());
		System.out.println(cl.getLine2()+c3.getLine2()+c4.getLine2());
		System.out.println(cl.getLine3()+c3.getLine3()+c4.getLine3());
		
		
	}

	public static void main(String[] args) {
		System.out.println("Fine");
		Account account = new Account("123456789");
		Integer i= new Integer(123456789);
		for(int j=0;j<550;j++){
			i=i+j;
			account.setAccountNumber(i.toString());
			account.print();
		}
		account.close();
	}

}
