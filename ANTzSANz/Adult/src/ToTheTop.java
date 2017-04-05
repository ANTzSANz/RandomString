import java.util.ArrayList;

public class ToTheTop {
			
		public static void main(String[] args){
			
			int somAge = 18;
			
			ArrayList<Students> areYouReady = getPosibleDrinks(somAge, Students.getAllStudents());
			
			if(areYouReady.isEmpty()){
				System.out.println("You have call to your Parents");
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
}
