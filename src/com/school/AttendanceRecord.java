package com.school;

public class AttendanceRecord implements Storable{
    private int studentId;
    private int courseId;
    private String status;
        
    public AttendanceRecord(int studentId,int courseId,String status){
        this.studentId = studentId;
        this.courseId = courseId;
        if(!(status.equalsIgnoreCase("Present")||status.equalsIgnoreCase("Absent"))){
            this.status = "Invalid";
        }else{
            this.status = status;
        }
    }

    public int getStudentId(){
        return this.studentId;
    }
    public int getCourseId(){
        return this.courseId;
    }
    
    public String getStatus(){
        return this.status;
    }

    public void displayRecord(){
        System.out.print("Student Id:"+this.studentId+"\t");
        System.out.print("Course Id :"+this.courseId+"\t");
        System.out.print("Status :"+this.status+"\n");
    } 

    @Override
    public String toDataString(){
        return studentId+","+courseId+","+status;
    }
}
