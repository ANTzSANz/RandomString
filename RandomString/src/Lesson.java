
public class Lesson {
	private Group group;
	private Teacher teacher;
	private long startOfLesson;
	private long lenghtOfLesson;
	private String lessonSubject;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public long getStartOfLesson() {
		return startOfLesson;
	}

	public void setStartOfLesson(long startOfLesson) {
		this.startOfLesson = startOfLesson;
	}

	public long getLenghtOfLesson() {
		return lenghtOfLesson;
	}

	public void setLenghtOfLesson(long lenghtOfLesson) {
		this.lenghtOfLesson = lenghtOfLesson;
	}

	public String getLessonSubject() {
		return lessonSubject;
	}

	public void setLessonSubject(String lessonSubject) {
		this.lessonSubject = lessonSubject;
	}

}
