import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RandomStringTest {

	@Test
	public void testGetRandomString() {
		String rndStr = new RandomString().getRandomString();
		boolean lengthIsCorrect = false;
		lengthIsCorrect = (rndStr.length() >= 8 && rndStr.length() <= 16);
		System.out.println(rndStr);
		assertEquals(true, lengthIsCorrect);

	}

	@Test
	public void testGetRandomNumber() {
		int rndNumber = new RandomString().getRandomNumber(2, 2);
		boolean numberIsCorrect = false;
		numberIsCorrect = (rndNumber == 2);
		assertEquals(true, numberIsCorrect);
	}

	@Test
	public void testAccEmailForContains() {
		String rndStr = new RandomString().getRandomString();
		String someEmail = new RandomString().getRandomAccEmail(rndStr);
		boolean accInEmail = false;
		accInEmail = someEmail.contains(rndStr);
		assertEquals(true, accInEmail);

	}

	@Test
	public void testAccEmailForContainsAt() {
		int count = 0;
		String rndStr2 = new RandomString().getRandomString();
		String someEmail2 = new RandomString().getRandomAccEmail(rndStr2);
		char[] symbols = someEmail2.toCharArray();
		for (char symbol : symbols) {
			if (String.valueOf(symbol).equals("@")) {
				count = count + 1;
			}

		}
		boolean accInEmail = false;
		accInEmail = someEmail2.contains(rndStr2);
		assertEquals(true, accInEmail);

	}

	@Test
	public void testAccEmailForContainsPoint() {
		int count = 0;
		String rndStr3 = new RandomString().getRandomString();
		String someEmail3 = new RandomString().getRandomAccEmail(rndStr3);
		char[] symbols = someEmail3.toCharArray();
		for (char symbol : symbols) {
			if (String.valueOf(symbol).equals(".")) {
				count = count + 1;
			}

		}
		boolean accInEmail = false;
		accInEmail = someEmail3.contains(rndStr3);
		assertEquals(true, accInEmail);

	}

	@Test
	public void testAccEmailForIndexPoint() {
		int indexOfAt = 0;
		int indexOfPoint = 0;
		String rndStr4 = new RandomString().getRandomString();
		String someEmail4 = new RandomString().getRandomAccEmail(rndStr4);
		char[] symbols4 = someEmail4.toCharArray();
		for (int i = 0; i < symbols4.length; i++) {
			if (String.valueOf(symbols4[i]).equals("@")) {
				indexOfAt = i;
			}
			if (String.valueOf(symbols4[i]).equals(".")) {
				indexOfPoint = i;

			}

			assertEquals(true, (indexOfPoint < indexOfAt));

		}

	}
}
