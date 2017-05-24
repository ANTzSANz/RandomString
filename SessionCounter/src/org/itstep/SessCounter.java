package org.itstep;

import java.util.ArrayList;

public class SessCounter {

	public static void main(String[] args) {
		
		String fileSep = System.getProperty("file.separator");
		
		String filePath = "D:"+fileSep+"test"+fileSep+"guests.txt";
		
		long startPeriod = (System.currentTimeMillis() - (1000*60*60*4));
		long endPeriod = System.currentTimeMillis();
		int count = getCountOfSessions(startPeriod, endPeriod, filePath);
		System.out.println(count);
	}
	
	public static int getCountOfSessions(long startPeriod, long endReriod, String filePath){
		int countOfSessions = 0;
		
		ArrayList<String> allSessions = ReaderFromFile.getTextFromFile(filePath);
		for (String line:allSessions){
			String[] words = line.split(" ");
			long sessTime = Long.valueOf(words[2]);
			if(startPeriod<=sessTime&&endReriod>=sessTime){
				countOfSessions++;
			}
		
	}
		return countOfSessions;
		
		
	}

}
