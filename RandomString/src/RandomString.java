public class RandomString {
	public static String getRandomString() {
		String returnedString = "";
		String stringSymbols = "abcdefghijklmnopqrstyvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ";
		char[] symbols = stringSymbols.toCharArray();
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
/*
	public static String addingAtToRandomString(String randomString) {
		String editedString = "";
		editedString = randomString + "@";
		return editedString;
	}
*/
	public static String getRandomAccEmail(String accountName) {
		int randomDomainIndex;
		// random case for domain choose
		randomDomainIndex = 1 + (int) (Math.random() * (6 - 1));
		String randomEmail = accountName;
		switch (randomDomainIndex) {
		case 1:
			randomEmail = randomEmail + "@gmail.com";
			break;
		case 2:
			randomEmail += "@mail.com";
			break;
		case 3:
			randomEmail += "@hotmail.com";
			break;
		case 4:
			randomEmail += "@bigmir.net";
			break;
		case 5:
			randomEmail += "@zoho.eu";
			break;
		default:
			randomEmail += "@gmail.com";
			break;
		}
		return randomEmail;
	}
	
}