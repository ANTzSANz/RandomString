import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

	public static long getCorrectTime(long dayInMills) {
		long correctTime = 0;
		Date date = new Date();
		date.setTime(dayInMills);
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		int day = gc.get(gc.DAY_OF_WEEK);
		System.out.println(day);

		if (day == 7 || day == 1) {
			System.out.println("It's a weekend");
			return correctTime;

		} else {
			int dayOfMonth = gc.get(gc.DAY_OF_MONTH);
			int month = gc.get(gc.MONTH);
			int year = gc.get(gc.YEAR);
			GregorianCalendar correctDate = new GregorianCalendar();
			correctDate.set(year, month, dayOfMonth, 9, 0, 0);
			correctTime = correctDate.getTimeInMillis();

		}
		return correctTime;
	}

	public static ArrayList<Lesson> getLessonsForDay(long dayInMills) {
		ArrayList<Lesson> lessons = new ArrayList<>();
		ArrayList<String> subjects = new ArrayList<>();
		subjects.add("Algebra");
		subjects.add("Physics");
		subjects.add("Geometry");
		subjects.add("Discrete mathematics");
		subjects.add("Statistics");
		subjects.add("Graphics");
		subjects.add("Computer science");
		subjects.add("History");
		subjects.add("History og Arts");
		subjects.add("English");
		long timeOfFirstLesson = getCorrectTime(dayInMills);
		if (timeOfFirstLesson == 0) {

		} else {
			ArrayList<Teacher> teachers = new ArrayList<>();
			for (int j = 0; j < 10; j++) {
				Teacher teacher = new Teacher();
				teacher.setName(RandomString.getRandomString());
				teacher.setLogin(RandomString.getRandomAccEmail(teacher.getName()));
				teacher.setSubject(subjects.get(j));
				teacher.setLastLogin(System.currentTimeMillis());
				teacher.setPassword("123456789");
				teachers.add(teacher);

			}
			Group group1 = getGroup();
			Group group2 = getGroup();
			
			Group group = getGroup();
			Lesson lesson = new Lesson();
			
			if(i%2==0){
				lesson.setGroup(group2);
			}else{
				lesson.setGroup(group1);
			}
			
			lesson.setGroup(group);
			lesson.setTeacher(teacher);

			for (int i = 0; i < getRandomNumber(4, 7); i++) {
				Lesson lesson = new Lesson();

			}
		}
		return lessons;
	}

	private static int getRandomNumber(int min, int max) {
		int number;
		number = (int) (min + Math.random() * (max - min) + 1);
		return number;
	}

	public static void main(String[] args) {

		ArrayList<Lesson> lessonsForDay = new ArrayList<>();
		lessonsForDay = getLessonsForDay(System.currentTimeMillis());

		/*
		 * for (int i = 0; i < 5; i++) { Lesson lesson = getLesson();
		 * lesson.setLessonSubject(lesson.getLessonSubject() + i + 1);
		 * lesson.setStartOfLesson(lesson.getStartOfLesson() - (i *
		 * (lesson.getLenghtOfLesson() + (15 * 60 * 1000))));
		 * lessonsForDay.add(lesson);
		 * 
		 * for (Lesson lsn : lessonsForDay) {
		 * System.out.println(lsn.getLessonSubject());
		 * 
		 * lsn.getGroup();
		 * 
		 * System.out.println("Group - " + lsn.getGroup().getName() + " has " +
		 * lsn.getGroup().getGroup().size());
		 */
		Date date = new Date();
		date.setTime(System.currentTimeMillis());
		SimpleDateFormat formating = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
		String dateAsString = formating.format(date);
		System.out.println(dateAsString);
		/*
		 * } /* /*
		 * 
		 * Group group = getGroup();
		 * 
		 * /* System.out.println(group.getName());
		 * System.out.println(group.getGroup().size());
		 * 
		 * for (Student student : group.getGroup()) { /*
		 * System.out.println(student.getLogin());
		 */
	}
	/*
	 * for(int i=0; i<12; i++){ Student student = getRndStudent();
	 * groupST19.addToGroup(student);
	 * 
	 * 
	 * Teacher teacher = new Teacher();
	 * 
	 * teacher.setName(RandomString.getRandomString());
	 * teacher.setLogin(RandomString.getRandomAccEmail(teacher.getName()));
	 * teacher.setLastLogin(System.currentTimeMillis());
	 * teacher.setPassword("assword");
	 * 
	 * 
	 * Accounts rndAccounts = new Accounts();
	 * 
	 * for(int i=0; i<15; i++){ Account account = new Account();
	 * account.setName(new RandomString().getRandomString()); String atMail =
	 * new RandomString().addingAtToRandomString(account.getName());
	 * account.setLogin(new RandomString().getRandomAccEmail(atMail));
	 * //account.setLogin(login); account.setPassword("123456789");
	 * account.setLastLogin(System.currentTimeMillis());
	 * rndAccounts.addToAccCollection(account); }
	 * 
	 * logger.log(Level.INFO,
	 * "Size of collection is "+rndAccounts.getAllRndAccounts().size()
	 * +" elements"); for(Account accElement : rndAccounts.getAllRndAccounts()){
	 * logger.log(Level.INFO, "Account name - "+accElement.getName()+"\n"+
	 * "Account login - "+accElement.getLogin()+"\n"+
	 * "Account password - "+accElement.getPassword()+"\n"+
	 * "Account last login - "+accElement.getLastLogin()); }
	 * 
	 * 
	 * Date date = new Date(); date.setTime(account.getLastLogin());
	 * SimpleDateFormat formating = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
	 * String dateAsString = formating.format(date);
	 * System.out.println(dateAsString);
	 */

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		ShowOurWorkBySide.logger = logger;
	}
}
