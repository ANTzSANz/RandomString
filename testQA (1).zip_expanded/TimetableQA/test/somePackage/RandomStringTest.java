package somePackage;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RandomStringTest {

	
	@Test
	public void testGetRandomString(){
		String rndStr = RandomString.getRandomString();
		boolean lenthIsCorrect = false;
		lenthIsCorrect = (rndStr.length()>=8 && rndStr.length()<=16);
		System.out.println(rndStr);
		assertEquals(true, lenthIsCorrect);
		
	}
	
	@Test
	public void testGetRandomNumber(){
		int rndNumber = RandomString.getRandomNumber(2, 3);
		boolean numberIsCorrect = false;
		numberIsCorrect = (rndNumber>=2&&rndNumber<=3);
		assertEquals(true, numberIsCorrect);
	}
	
	@Test
	public void testAccEmailForContains(){
		String rndStr1 = RandomString.getRandomString();
		String someEmail1 = RandomString.getRandomAccEmail(rndStr1);
		boolean accInEmail1 = false;
		accInEmail1 = someEmail1.contains(rndStr1);
		assertEquals(true, accInEmail1);
		
	}
	
	@Test
	public void testAccEmailForContainsAt(){
		int count = 0;		
		String rndStr2 = RandomString.getRandomString();
		String someEmail2 = RandomString.getRandomAccEmail(rndStr2);
		char[] symbols = someEmail2.toCharArray();
		for (char symbol : symbols) {
			if(String.valueOf(symbol).equals("@")){
				count=count+1;
			}
		}
		assertEquals(1, count);
		
	}
	
	@Test
	public void testAccEmailForIndexOfPoint(){
		int indexOfAt = 0;	
		int indexOfPoint = 0;
		String rndStr3 = RandomString.getRandomString();
		String someEmail3 = RandomString.getRandomAccEmail(rndStr3);
		char[] symbols3 = someEmail3.toCharArray();
		for(int i=0; i<symbols3.length; i++) {
			if(String.valueOf(symbols3[i]).equals("@")){
				indexOfAt = i;
			}
			if(String.valueOf(symbols3[i]).equals(".")){
				indexOfPoint = i;
			}
		}
		assertEquals(true, (indexOfPoint>indexOfAt));
		
	}
	
	
}
