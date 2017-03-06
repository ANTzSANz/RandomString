import java.util.ArrayList;

public class RandomString {
	public static void main(String[] args) {
		String randomString = getRandomString();
		System.out.println(randomString);
		String editedString = addingAtToRandomString(randomString);
		
		ArrayList<String> rndString = new ArrayList<>();
		rndString.
	}

	public static String getRandomString() {

		String returnedString = "";
		String stringSymbolsOne = "abcdefghijklmnopqrstyvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ";
		char[] symbols = stringSymbolsOne.toCharArray();
		int randomLength = getRandomNumber(8, 16);
		for (int i = 0; i < randomLength; i++) {
			int randomIndex = getRandomNumber(0, symbols.length);
			returnedString = returnedString + symbols[randomIndex];
		}

		return returnedString;
	}

	public static int getRandomNumber(int min, int max) {
		int randomNumber = (int) (min + Math.random() * (max - min));
		return randomNumber;
	}

	public static String addingAtToRandomString(String randomString) {
		String editedString = "";

		editedString = randomString + "@";

		return editedString;
	}

}