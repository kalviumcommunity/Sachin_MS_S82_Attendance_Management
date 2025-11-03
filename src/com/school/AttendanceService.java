package com.school;
import java.util.*;



public class AttendanceService {
    private  List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;
    private RegistrationService registrationService;

    public AttendanceService(FileStorageService storageService,RegistrationService registrationService){
        this.storageService = storageService;
        this.registrationService = registrationService;
        this.attendanceLog = new ArrayList<>();
    }

    public void markAttendance(Student student, Course course, String status){
        attendanceLog.add(new AttendanceRecord(student.getId(),course.getCourseId(),status));
    }   

    public void markAttendance(int studentId, int courseId, String status){
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);

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
