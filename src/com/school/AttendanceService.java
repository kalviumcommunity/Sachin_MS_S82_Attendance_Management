package com.school;
import java.util.*;



public class AttendanceService {
    private  List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    public AttendanceService(FileStorageService storageService){
        this.storageService = storageService;
        this.attendanceLog = new ArrayList<>();
    }

    public void markAttendance(Student student, Course course, String status){
        attendanceLog.add(new AttendanceRecord(student.getId(),course.getCourseId(),status));
    }   
    private Student findStudentById(List<Student> students,int studentId){
        for(Student student:students){
            if(student.getId() == studentId){
                return student;
            }
        }
        return students.get(0);
    }
    private Course findCourseById(List<Course> courses, int courseId){
        for(Course course:courses){
            if(course.getCourseId() == courseId){
                return course;
            }
        }
        return courses.get(0);
    }
    
    public void markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses){
        Student student = findStudentById(allStudents,studentId);
        Course course = findCourseById(allCourses,courseId);

        markAttendance(student, course, status);

    }
    public void displayAttendanceLog(){
        for(AttendanceRecord attendanceRecord: attendanceLog){
            System.out.println();
            System.out.print("\n StudentId : "+attendanceRecord.getStudentId());
            System.out.print("CourseId : "+attendanceRecord.getCourseId());
            System.out.print("Status : "+attendanceRecord.getStatus());
        }
    }
    
    public void displayAttendanceLog(Student student){
        for(AttendanceRecord a:attendanceLog){
            if(a.getStudentId() == student.getId()){
            System.out.println("\n StudentId : "+a.getStudentId());
            System.out.println(" CourseId : "+a.getCourseId());
            System.out.println("  Status : "+a.getStatus());
            }
        }
    }
    public void displayAttendanceLog(Course course){
        for(AttendanceRecord a:attendanceLog){
            if(a.getCourseId() == course.getCourseId()){
            
            System.out.println("\n StudentId : "+a.getStudentId());
            System.out.println(" CourseId : "+a.getCourseId());
            System.out.println(" Status : "+a.getStatus());

            }
        }
    }
    public void saveAttendanceData(){
        storageService.saveData(attendanceLog, "attendanceLog.txt");
    }
}
