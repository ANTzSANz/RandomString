package org.itstep;

import static org.junit.Assert.*;

import org.junit.Test;

public class SessCounterTest {

	@Test
	public final void testGetCountOfSessions1() {
		String fileSep = System.getProperty("file.separator");
		 
		String filePath = "D:"+fileSep+"test"+fileSep+"guests.txt";
		
		long startPeriod = (System.currentTimeMillis() - (1000*60*60*6));
		long endPeriod = System.currentTimeMillis();
		int count = SessCounter.getCountOfSessions(startPeriod, endPeriod, filePath);
		
		assertEquals(15, count);
	}
	@Test
	public final void testGetCountOfSessions2() {
		String fileSep = System.getProperty("file.separator");
		 
		String filePath = "D:"+fileSep+"test"+fileSep+"guests.txt";
		
		long startPeriod = (System.currentTimeMillis() - (1000*60*60*1));
		long endPeriod = System.currentTimeMillis();
		int count = SessCounter.getCountOfSessions(startPeriod, endPeriod, filePath);
		
		assertEquals(0, count);
	}
}
