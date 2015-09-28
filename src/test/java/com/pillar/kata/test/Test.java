package com.pillar.kata.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;

import com.pillar.kata.KataOcr;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KataOcr kocr = new KataOcr();
		MockInputStream mis = new MockInputStream();
		ByteArrayOutputStream bos= new ByteArrayOutputStream();
		mis.addContent("    _  _  _  _  _  _     _ ");
		mis.addContent("|_||_ |_|| | _| _| _||_||_ ");
		mis.addContent("  | _| _||_||_ |_  _|  | _|");
		mis.addContent("");
		kocr.parse(mis,bos);
		System.out.println( bos.toString());

	}

}
