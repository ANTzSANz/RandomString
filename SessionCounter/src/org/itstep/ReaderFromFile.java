package org.itstep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderFromFile{

public static ArrayList<String> getTextFromFile(String filePath){
	
	ArrayList<String> textFromFile = new ArrayList<>();
	
	try {
		
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		
		String line="";
		
		while ((line = reader.readLine()) != null) {
			
			textFromFile.add(line);
			
		}
		
		reader.close();
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	return textFromFile;
}

}
