package com.pillar.kata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KataOcr {
	
	public static int statusCode=0;
	private int accountCount=0;
	private int errorCount=0;
	private int lineCount=1;
	
	public int getErrorCount() {
		return errorCount;
	}
	public int getAccountCount() {
		return accountCount;
	}
	public int getLineCount() {
		return lineCount;
	};
	
	
	private final String  msgAccountSpan = "account lines doesnt span 3, at line:";
	private final String msgParseErr="account parse exception, at line:";
	private final String msgAccount=" line no:";
	private final String  eofl="\r\n";
	private final static Logger logger = Logger.getLogger(KataOcr.class .getName()); 

	public void parse(InputStream fis, OutputStream fos) {
		Account account=  new Account();
		try{
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String line=br.readLine();
			int j=1;
			
			while(line!=null){
				if(j==1) account.setLine1(line);
				if(j==2) account.setLine2(line);
				if(j==3) account.setLine3(line);
				if(line.trim().length()==0) {				
					try{
						if (j!=4) {
							errorCount++;
							fos.write((msgAccountSpan+lineCount).getBytes());
							fos.write(eofl.getBytes());

							logger.log(Level.SEVERE, msgAccountSpan+lineCount);
						}else{
							account.read();
							fos.write((account.getAccountNumber()+ msgAccount+lineCount).getBytes());
							fos.write(eofl.getBytes());
							accountCount++;
						}
					}catch(AccountException accountException){
						fos.write((msgParseErr+lineCount).getBytes());
						fos.write(eofl.getBytes());
						errorCount++;
						logger.log(Level.SEVERE, 
								accountException.getMessage()+msgAccount+lineCount,
								accountException);
					}
					
					j=0;
				}
				j++;
				lineCount++;
				line=br.readLine();
			}
			br.close();
			fos.close();
			logger.log(Level.INFO,
					"processed lines "+lineCount);
			logger.log(Level.INFO,
					"errors occured "+errorCount);
			logger.log(Level.INFO, "valid Accounts "+accountCount);
			
		}catch(FileNotFoundException nofile){
			statusCode=123;
			logger.severe("File doesn't exist ");
		}catch(IOException ioex){
			statusCode=234;
			logger.severe("Error reading/writing file");
		}
	}

	public static void main(String[] args) {
		try{
			FileInputStream fis = new FileInputStream(new File(args[0]));
			FileOutputStream fos = new FileOutputStream(new File(args[1]));
			KataOcr koc = new KataOcr();
			koc.parse(fis,fos);
		}catch(ArrayIndexOutOfBoundsException argsException ){
			logger.severe("input/output file can not be null, usage is \n"+
					       "com.pillar.kata.KataOcr inputFile outputFile");
		}catch(FileNotFoundException fne){
			logger.severe("input/output file not found error");

		}
	}
}
