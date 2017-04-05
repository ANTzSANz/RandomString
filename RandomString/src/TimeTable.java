package somePackage;
import java.util.ArrayList;

public class TimeTable {
	
	public ArrayList<Lesson> lessons = new ArrayList<>();
	
		
	public void addLesson(Lesson lesson){
		lessons.add(lesson);
	}
	
	public void removeLesson(Lesson lesson){
		lessons.remove(lesson);
	}
	
	public ArrayList<Lesson> getLessons(){
		return lessons;
	}
}
