import static org.junit.Assert.*;

import org.junit.Test;

public class WindowTest {

	@Test
	public void testGetResultOnes() {
		Window window = new Window();
		int result = window.getResult(1,1,"+");
		assertEquals(2, result);
		
	}
	@Test
	public void testGetResultPlusZero() {
		Window window = new Window();
		int result = window.getResult(0,0,"+");
		assertEquals(0, result);
	}
	
}
