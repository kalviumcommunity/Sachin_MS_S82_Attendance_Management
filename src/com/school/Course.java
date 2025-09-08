package com.school;


public class Course implements Storable{
    private int courseId;
    private String courseName;
    private static int nextCourseIdCounter = 1;

    public Course(String courseName){
        this.courseName = courseName;
        this.courseId = nextCourseIdCounter++;
    }
    public String getCourseName(){
        return this.courseName;
    }
    public int getCourseId(){
        return this.courseId;
    }

    public void displayDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Id: " + courseId);
    }
    @Override
    public String toDataString(){
        return courseId+","+courseName;
    }
    
}