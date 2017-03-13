import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShowOurWorkBySide {
	private static Logger logger = Logger.getLogger(ShowOurWorkBySide.class.getName());

	public static Student getRndStudent() {
		Student student = new Student();
		student.setName(RandomString.getRandomString());
		student.setLogin(RandomString.getRandomAccEmail(student.getName()));
		student.setLastLogin(System.currentTimeMillis());
		student.setPassword("password");
		return student;
	}

	public static Group getGroup() {
		Group group = new Group();
		group.setName(RandomString.getRandomString());
		for (int i = 0; i < 12; i++) {
			Student student = getRndStudent();
			group.addToGroup(student);
		}
		return group;
	}

	public static Teacher getTeacher() {
		Teacher teacher = new Teacher();
		teacher.setName(RandomString.getRandomString());
		teacher.setLogin(RandomString.getRandomAccEmail(teacher.getName()));
		teacher.setLastLogin(System.currentTimeMillis());
		teacher.setPassword("assword");
		return teacher;
	}

	public static Lesson getLesson() {
		Lesson lesson = new Lesson();
		lesson.setLessonSubject("lesson");
		lesson.setTeacher(getTeacher());
		lesson.setGroup(getGroup());
		lesson.setLenghtOfLesson(1000 * 60 * 45);
		lesson.setStartOfLesson(System.currentTimeMillis());
		return lesson;
	}

	public static void main(String[] args) {

		ArrayList<Lesson> lessonsForDay = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			Lesson lesson = getLesson();
			lesson.setLessonSubject(lesson.getLessonSubject()+i+1);
			lesson.setStartOfLesson(lesson.getStartOfLesson()- (i*(lesson.getLenghtOfLesson() +(15*60*1000))));
			lessonsForDay.add(lesson);
			
		for (Lesson lsn: lessonsForDay){
				System.out.println(lsn.getLessonSubject());
				Date date = new Date(); 
				date.setTime(lsn.getStartOfLesson());
				SimpleDateFormat formating = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss"); 
				String dateAsString = formating.format(date); 
				System.out.println(dateAsString);
			
			}
		}

		Group group = getGroup();
		/*
		 * System.out.println(group.getName());
		 * System.out.println(group.getGroup().size()); for(Student
		 * student:group.getGroup()){ System.out.println(student.getLogin()); }
		 * 
		 * for(int i=0; i<12; i++){ Student student = getRndStudent();
		 * groupST19.addToGroup(student);
		 */

		Teacher teacher = new Teacher();
		/*
		 * teacher.setName(RandomString.getRandomString());
		 * teacher.setLogin(RandomString.getRandomAccEmail(teacher.getName()));
		 * teacher.setLastLogin(System.currentTimeMillis());
		 * teacher.setPassword("assword");
		 * 
		 * 
		 * Accounts rndAccounts = new Accounts();
		 * 
		 * for(int i=0; i<15; i++){ Account account = new Account();
		 * account.setName(new RandomString().getRandomString()); String atMail
		 * = new RandomString().addingAtToRandomString(account.getName());
		 * account.setLogin(new RandomString().getRandomAccEmail(atMail));
		 * //account.setLogin(login); account.setPassword("123456789");
		 * account.setLastLogin(System.currentTimeMillis());
		 * rndAccounts.addToAccCollection(account); }
		 * 
		 * logger.log(Level.INFO,
		 * "Size of collection is "+rndAccounts.getAllRndAccounts().size()
		 * +" elements"); for(Account accElement :
		 * rndAccounts.getAllRndAccounts()){ logger.log(Level.INFO,
		 * "Account name - "+accElement.getName()+"\n"+
		 * "Account login - "+accElement.getLogin()+"\n"+
		 * "Account password - "+accElement.getPassword()+"\n"+
		 * "Account last login - "+accElement.getLastLogin()); }
		 * 
		 * 
		 * Date date = new Date(); date.setTime(account.getLastLogin());
		 * SimpleDateFormat formating = new
		 * SimpleDateFormat("YYYY/MM/dd HH:mm:ss"); String dateAsString =
		 * formating.format(date); System.out.println(dateAsString);
		 */
	}
}
