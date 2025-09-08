package  com.school;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        
            students.add(new Student("Ram","A"));
            students.add(new Student("Sita","B"));
            students.add(new Student("Lakshman","B"));
            students.add(new Student("Hanuman","F"));
        

        ArrayList<Course> courses = new ArrayList<>();
         
            courses.add(new Course("Full Stack Developer"));
            courses.add(new Course("Data Science"));
            courses.add(new Course("Cloud Computing"));
            courses.add(new Course("Blockchain Development"));
        

        ArrayList<AttendanceRecord> attendanceLog = new ArrayList<>();

        for(int i =0;i<4;i++){
            String pres = i%2==0?"Present":"Absent";
            if(i == 3){
                pres = "aa";
            }
            attendanceLog.add(new AttendanceRecord(students.get(i).getId(),courses.get(i).getCourseId(),pres));
        }
        System.out.println("");

        System.out.println("Attendance Records:");
        System.out.println("");

        for(AttendanceRecord a:attendanceLog){
            a.displayRecord();
        }

        FileStorageService storage = new FileStorageService();

        storage.saveData(students, "students.txt");
        storage.saveData(courses, "courses.txt");
        storage.saveData(attendanceLog, "attendance_log.txt");
    }
}