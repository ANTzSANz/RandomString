package somePackage;

import java.util.ArrayList;

public class RandomAccount {

	public static String getRandomName(int index) {
		String name = "";
		ArrayList<String> names = new ArrayList<>();
		names.add("Alexandr");
		names.add("Olga");
		names.add("Michael");
		names.add("Milena");
		names.add("Roman");
		names.add("Elena");
		names.add("Victor");
		names.add("Georg");
		names.add("Andrey");
		names.add("Anastasia");
		names.add("Vlad");
		names.add("Mark");
		if(index >= names.size()){
			index = getRandomNumber(0, (names.size()-1));
		}
		name = names.get(index);
		return name;
	}
	
	public static String getRandomAccEmail(String accountName) {

		int randomDomainIndex;
		// random case for domain choose
		randomDomainIndex = 1 + (int) (Math.random() * 5);
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
	
	public static int getRandomNumber(int min, int max) {
		int randomNumber = (int) (min + (Math.random() * (max - min)+1));
		return randomNumber;
	}

}