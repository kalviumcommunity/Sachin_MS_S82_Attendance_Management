package com.school;
import java.util.*;

public class Course implements Storable{
    private int courseId;
    private String courseName;
    private int capacity;
    private static int nextCourseIdCounter = 1;
    List<Student> enrolledStudents;

    public Course(String courseName,int capacity){
        this.courseName = courseName;
        this.courseId = nextCourseIdCounter++;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }
    public String getCourseName(){
        return this.courseName;
    }
    public int getCourseId(){
        return this.courseId;
    }
    public int getCapacity(){
        return capacity;
    }

    public List<Student> getEnrolledStudents(){
        return enrolledStudents;
    }
    public int getNumberOfEnrolledStudents(){
        return enrolledStudents.size();
    }

public boolean addStudent(Student student) {
    if (enrolledStudents.size() < capacity) {
        enrolledStudents.add(student);  
        System.out.println(student.getName() + " enrolled in " + courseName);
        return true;
    } else {
        System.out.println(courseName + " is full. Could not enroll " + student.getName());
        return false;
    }
}

    public void displayDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Id: " + courseId);
        System.out.println("Capacity: "+capacity);
        System.out.println("Current Enrollment: "+enrolledStudents.size());
    }
    @Override
    public String toDataString(){
        return courseId+", "+courseName+", "+capacity;
    }
    
}