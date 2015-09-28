package com.pillar.kata.test;


import java.io.IOException;
import java.io.InputStream;


public class MockInputStream extends InputStream{



	public MockInputStream() {

		content = new StringBuffer();
	}

	private StringBuffer content;
	private int position = 0;

	public void setContent(StringBuffer content) {
		this.content = content;
	}
	public StringBuffer getContent() {
		return content;
	}
	@Override
	public int read() throws IOException {
		if (position == this.content.length()) {
			return -1;
			}
		return this.content.charAt(this.position++);
	}

	public void addContent(String text){
		content.append(text);
		content.append("\n");
	}

	public void close() throws IOException {
	
		super.close();
		}
}
