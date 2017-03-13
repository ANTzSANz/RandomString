
public class Human {
	
	private String name;
	private int height = 156;
	private int weight = 65;
	private int age = 28;
	
	public Human(String inName){
		name = inName;
	}
	
	public Human(String name, int height, int weight){
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	
	public int getHeight() {
		return height;
	}
	public int getWeight() {
		return weight;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	
	public float getIndexValue(){
		
		float heightInMeters = (float) height/100;
		
		float res = weight / (heightInMeters * heightInMeters);
		
		return res;
	}
		
	
}
