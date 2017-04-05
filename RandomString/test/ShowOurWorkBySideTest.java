package somePackage;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

public class ShowOurWorkBySideTest {

    @Test
    public void getRndStudentName() {
        Student student = ShowOurWorkBySide.getRndStudent(3);
        assertEquals("Milena",student.getName());
    }
    @Test
    public void getRndStudentEmail() {
        Student student = ShowOurWorkBySide.getRndStudent(3);
        assertTrue(student.getLogin().contains("Milena"));
}
    @Test
    public void testGetGroupSiza(){
        int size = ShowOurWorkBySide.getGroup("someGroup").getGroup().size();
        assertEquals(12,size);
        
    }
    @Test
    public void testGetTeacherName(){
        Teacher teacher = ShowOurWorkBySide.getTeacher();
        assertEquals("TeacherAlexandr",teacher.getName());
    
}
    @Test
    public void testGetCorrectTimeForWeekend(){
        long weekend = ShowOurWorkBySide.getCorrectTime((System.currentTimeMillis()-(24*60*60*1000)));
        assertEquals(0,weekend);
    }
    
    @Test
    public void testGetCorrectTimeForWorkday(){
        long workday = ShowOurWorkBySide.getCorrectTime(System.currentTimeMillis());
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(workday);
        int correctHour = gc.get(gc.HOUR);
        int correctMenute = gc.get(gc.MINUTE);
        boolean correctTime = (correctHour==9)&&(correctMenute==0);
        assertTrue(correctTime);
}
    
}