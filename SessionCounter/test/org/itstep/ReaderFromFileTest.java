package org.itstep;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ReaderFromFileTest {

	@Test
	public final void testGetTextFromFile() {
	 
		String fileSep = System.getProperty("file.separator");
	 
		String filePath = "D:"+fileSep+"test"+fileSep+"guests.txt";
		
		ArrayList<String> lines = ReaderFromFile.getTextFromFile(filePath);
		
		assertEquals(16, lines.size());
	}

}
