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
        

        List<Course> courses = new ArrayList<>();
         
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
        FileStorageService storage = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storage);

        for(int i =0;i<4;i++){
            String pres = i%2==0?"Present":"Absent";
            if(i == 3){
                pres = "aa";
            }
            attendanceService.markAttendance(students.get(i), courses.get(i), pres);
        }

        System.out.println("\n Attendance Records: ");
        attendanceService.displayAttendanceLog();

        
        storage.saveData(students, "students.txt");
        storage.saveData(courses, "courses.txt");
        attendanceService.saveAttendanceData();
    }
}