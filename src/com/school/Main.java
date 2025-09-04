package  com.school;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Student[] students = {
            new Student("Ram","A"),
            new Student("Sita","B"),
            new Student("Lakshman","B"),
            new Student("Hanuman","F")
        };

        Course[] courses = {
            new Course("Full Stack Developer"),
            new Course("Data Science"),
            new Course("Cloud Computing"),
            new Course("Blockchain Development")
        };

        ArrayList<AttendanceRecord> attendanceLog = new ArrayList<>();

        for(int i =0;i<4;i++){
            String pres = i%2==0?"Present":"Absent";
            if(i == 3){
                pres = "aa";
            }
            attendanceLog.add(new AttendanceRecord(students[i].getId(),courses[i].getCourseId(),pres));
        }
        System.out.println("");

        System.out.println("Attendance Records:");
        System.out.println("");
        for(AttendanceRecord a:attendanceLog){
            a.displayRecord();
        }
    }
}