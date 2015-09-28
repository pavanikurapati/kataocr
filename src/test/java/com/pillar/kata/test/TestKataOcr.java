package com.pillar.kata.test;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import org.junit.Test;

import com.pillar.kata.KataOcr;

public class TestKataOcr {

	@Test
	public void parse() {
		KataOcr kocr = new KataOcr();
		MockInputStream mis = new MockInputStream();
		ByteArrayOutputStream bos= new ByteArrayOutputStream();
		mis.addContent("    _  _  _  _  _  _     _ ");
		mis.addContent("|_||_ |_|| | _| _| _||_||_ ");
		mis.addContent("  | _| _||_||_ |_  _|  | _|");
		mis.addContent("");
		kocr.parse(mis,bos);
		assertEquals("459022345 line no:4\r\n", bos.toString());
			        
	}
	

	@Test 
	public void parseWithError(){
		KataOcr kocr = new KataOcr();
		MockInputStream mis = new MockInputStream();
		ByteArrayOutputStream bos= new ByteArrayOutputStream();
		mis.addContent("    _  _  _  _  _  _     _ ");
		mis.addContent("|_||_ |_|| | _| _| _||_||_ ");
		mis.addContent("   _| _||_||_ |_  _|  | _|");
		mis.addContent("");
		kocr.parse(mis,bos);
		assertEquals("account parse exception, at line:4\r\n", bos.toString());

	}
	
	@Test 
	public void parseMultipleAccount(){
		KataOcr kocr = new KataOcr();
		MockInputStream mis = new MockInputStream();
		ByteArrayOutputStream bos= new ByteArrayOutputStream();
		mis.addContent("    _  _  _  _  _  _     _ ");
		mis.addContent("|_||_ |_|| | _| _| _||_||_ ");
		mis.addContent("  | _| _||_||_ |_  _|  | _|");
		mis.addContent("");
		mis.addContent("    _  _  _  _  _  _     _ ");
		mis.addContent("|_||_ |_|| | _| _| _||_||_ ");
		mis.addContent("");
		mis.addContent("    _  _  _  _  _  _     _ ");
		mis.addContent("|_||_ |_|| | _| _| _||_||_ ");
		mis.addContent("  | _| _||_||_ |_  _|  | _|");
		mis.addContent("");
		kocr.parse(mis,bos);
		assertEquals(12, kocr.getLineCount());
		assertEquals(1, kocr.getErrorCount());
		assertEquals(2, kocr.getAccountCount());


	}	
}
