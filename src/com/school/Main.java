package com.school;

import java.util.*;

public class Main {

    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("School Directory:");
        for (Person p : people) {
            p.displayDetails();
        }
    }

    public static void main(String[] args) {

        FileStorageService storageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storageService);
        AttendanceService attendanceService = new AttendanceService(storageService, registrationService);

        registrationService.registerStudent(new Student("Ram", "A"));
        registrationService.registerStudent(new Student("Sita", "B"));
        registrationService.registerStudent(new Student("Lakshman", "B"));
        registrationService.registerStudent(new Student("Hanuman", "F"));

        registrationService.createCourse("Full Stack Developer", 2);
        registrationService.createCourse("Data Science", 2);
        registrationService.createCourse("Cloud Computing", 1);
        registrationService.createCourse("Blockchain Development", 1);

        displaySchoolDirectory(registrationService.getAllPeople());

        System.out.println("\n--- Enrolling Students ---");
        List<Student> students = registrationService.getStudents();
        List<Course> courses = registrationService.getCourses();

        registrationService.enrollStudentInCourse(students.get(0), courses.get(0)); // Ram → Full Stack
        registrationService.enrollStudentInCourse(students.get(1), courses.get(0)); // Sita → Full Stack
        registrationService.enrollStudentInCourse(students.get(2), courses.get(0)); // Lakshman → Full Stack (should fail, capacity=2)
        registrationService.enrollStudentInCourse(students.get(3), courses.get(2)); // Hanuman → Cloud (ok)

        System.out.println("\n--- Course Details After Enrollment ---");
        for (Course c : registrationService.getCourses()) {
            c.displayDetails();
            System.out.println();
        }

        System.out.println("\n--- Marking Attendance ---");
        attendanceService.markAttendance(1, 1, "Present");
        attendanceService.markAttendance(2, 2, "Absent");
        attendanceService.markAttendance(3, 3, "Present");
        attendanceService.markAttendance(4, 4, "AA");

        System.out.println("\nAttendance Records:");
        attendanceService.displayAttendanceLog();

        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();
    }
}
