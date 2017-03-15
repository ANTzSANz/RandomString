import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RandomStringTest {

	@Test
	public void testGetRandomString(){
		String rndStr = new RandomString().getRandomString();
		boolean lengthIsCorrect = false;
		lengthIsCorrect = (rndStr.length()>=8 && rndStr.length()<=16);
		System.out.println(rndStr);
		assertEquals(true, lengthIsCorrect);
		
	}
	
}
