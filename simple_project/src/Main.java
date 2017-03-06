
public class Main {
	
	static void print(String message){
		for (int i=0; i<3; i++)
			System.out.println(message);
	}

	public static void main(String[] args){
		print("Hello");
		print("Bay");
		
		Human myHuman = new Human("Pavlo", 175, 87);
		print("myHuman height" +myHuman.getHeight());
		
		print("myHuman height" +myHuman.getName());
		
		double index = myHuman.getIndexValue();
		
		print("index for"+myHuman.getName()+ " is " +myHuman.getIndexValue());
			
		Human myHumanSecond = new Human("Olga");
				
		print("myHuman height - "+myHumanSecond.getName());	
	}
}
