import java.util.ArrayList;

public class StringCollection {

	ArrayList<String> strCollection = new ArrayList<>();
	
	public void addToStringCollection(String rndString){
		
		strCollection.add(rndString);
		
		
	}
	
	
	public ArrayList<String> getAllRndString(){
		return strCollection;
	}
	
}
