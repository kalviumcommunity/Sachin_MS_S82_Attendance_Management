package com.school;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationService{
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Staff> staffMembers;
    private List<Course> courses;
    private FileStorageService fileStorageService;
    
    public RegistrationService(FileStorageService fileStorageService){
        this.fileStorageService = fileStorageService;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.courses = new ArrayList<>();

    }

    public void registerStudent(Student student){
        students.add(student);
    }
    public void registerTeacher(Teacher teacher){
        teachers.add(teacher);
    }
    public void registerStaff(Staff staff){
        staffMembers.add(staff);
    }
    public void registerCourse(Course course){
        courses.add(course);
    }

    public List<Student> getStudents(){
        return students;
    }
    public List<Teacher> getTeachers(){
        return teachers;
    }
    public List<Staff> getStaffs(){
        return staffMembers;
    }
    public List<Course> getCourses(){
        return courses;
    }
    
    public Student findStudentById(int id){
    for (Student s :students) {
        if (s.getId() == id) {
            return s;
        }
    }
    return null;
    }

    public Course findCourseById(int id){
        for(Course c:courses){
            if(c.getCourseId() == id){
                return c;
            }
        }
        return null;
    }
    public List<Person> getAllPeople(){
        List<Person> all = new ArrayList<>();
        all.addAll(students);
        all.addAll(teachers);
        all.addAll(staffMembers);
        return all;
    }
    public void saveAllRegistrations() {
        fileStorageService.saveData(students,"students.txt");
        fileStorageService.saveData(teachers,"teachers.txt");
        fileStorageService.saveData(staffMembers, "staff.txt");
        fileStorageService.saveData(courses,"courses.txt");
    }
}
