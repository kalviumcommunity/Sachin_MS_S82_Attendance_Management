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

        registrationService.registerStudent(new Student( "Ram", "A"));
        registrationService.registerStudent(new Student( "Sita", "B"));
        registrationService.registerStudent(new Student( "Lakshman", "B"));
        registrationService.registerStudent(new Student( "Hanuman", "F"));

        registrationService.registerCourse(new Course( "Full Stack Developer"));
        registrationService.registerCourse(new Course( "Data Science"));
        registrationService.registerCourse(new Course( "Cloud Computing"));
        registrationService.registerCourse(new Course( "Blockchain Development"));

        displaySchoolDirectory(registrationService.getAllPeople());

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
