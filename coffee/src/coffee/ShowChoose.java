package coffee;

import java.util.ArrayList;

public class ShowChoose {
	
	public static void main(String[] args){
		
		int sum = 500;
		
		ArrayList<Drink> posibleDrinks = getPosibleDrinks(sum, Drinks.getAllDrinks());
		
		if(posibleDrinks.isEmpty()){
			System.out.println("You have to input more cash");
		}
		
		
		for(Drink checkedDrink:posibleDrinks){
			
			System.out.println("You can buy drink " + checkedDrink.getName() + " and your payback is " + (sum - checkedDrink.getPrice())); 
		}
		
	}

	private static ArrayList<Drink> getPosibleDrinks(int sum, ArrayList<Drink> allDrinks) {
		
		ArrayList<Drink> posibleDrinks = new ArrayList<>();
		
		for(Drink someDrink:allDrinks){
			
			if(someDrink.getPrice()<=sum){
				
				posibleDrinks.add(someDrink);
			}
		}
				
		return posibleDrinks;
	}

}
