package  com.school;
import java.util.*;

public class Main {

    public static void displaySchoolDirectory(List<Person> people){
        System.out.println("School Directory:");
        for(Person p:people){
            p.displayDetails();
        }
    }
    public static void main(String[] args) {

        List<Person> schoolPeople = new ArrayList<>();
        
            schoolPeople.add(new Student("Ram","A"));
            schoolPeople.add(new Student("Sita","B"));
            schoolPeople.add(new Student("Lakshman","B"));
            schoolPeople.add(new Student("Hanuman","F"));
        

        ArrayList<Course> courses = new ArrayList<>();
         
            courses.add(new Course("Full Stack Developer"));
            courses.add(new Course("Data Science"));
            courses.add(new Course("Cloud Computing"));
            courses.add(new Course("Blockchain Development"));
        
        List<Student> students = new ArrayList<>();

        for(Person p:schoolPeople){
            if(p instanceof Student){
                students.add((Student) p);
            }
        }
        displaySchoolDirectory(schoolPeople);
        ArrayList<AttendanceRecord> attendanceLog = new ArrayList<>();

        for(int i =0;i<4;i++){
            String pres = i%2==0?"Present":"Absent";
            if(i == 3){
                pres = "aa";
            }
            attendanceLog.add(new AttendanceRecord(schoolPeople.get(i).getId(),courses.get(i).getCourseId(),pres));
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