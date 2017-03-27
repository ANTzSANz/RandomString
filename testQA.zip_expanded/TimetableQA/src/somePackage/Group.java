package somePackage;
import java.util.ArrayList;

public class Group {
	private String name;
	private ArrayList<Student> group = new ArrayList<>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addToGroup(Student student){
		group.add(student);
	}
	
	public ArrayList<Student> getGroup(){
		return group;
	}
	
	public void deleteStudent(Student student){
		group.remove(student);
	}
}
