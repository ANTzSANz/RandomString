import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RandomString {

	public static Logger logger = Logger.getLogger(RandomString.class.getName());

	public static void main(String[] args) {
		String randomString = getRandomString();
		// System.out.println(randomString);
		logger.log(Level.INFO, randomString);
		String editedString = addingAtToRandomString(randomString);
		logger.log(Level.INFO, editedString);
		
		StringCollection strCollection = new StringCollection();
		
		for(int i = 0; i<10; i++){
			strCollection.addToStringCollection(addingAtToRandomString(getRandomString()));
			
		}
		
		for(String elementOfCollection: strCollection.getAllRndString()){
			logger.log(Level.INFO, "Element is - " + elementOfCollection);
		}
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
		System.out.println(editedString);
		return editedString;

	}

}