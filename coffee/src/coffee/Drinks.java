package coffee;

import java.util.ArrayList;

public class Drinks {

	public static ArrayList<Drink> getAllDrinks(){
		
		ArrayList<Drink> drinks = new ArrayList<>();
		
		Drink drink1 = new Drink();
		drink1.setName("Espresso");
		drink1.setPrice(600);
		drinks.add(drink1);
		
		Drink drink2 = new Drink();
		drink2.setName("Americano");
		drink2.setPrice(700);
		drinks.add(drink2);
		
		Drink drink3 = new Drink();
		drink3.setName("Americano with milk");
		drink3.setPrice(800);
		drinks.add(drink3);
		
		Drink drink4 = new Drink();
		drink4.setName("Capucino");
		drink4.setPrice(800);
		drinks.add(drink4);
		
		Drink drink5 = new Drink();
		drink5.setName("Latte");
		drink5.setPrice(900);
		drinks.add(drink5);
		
				
		return drinks;
	}
	
	
	
}
