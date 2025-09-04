package com.school;

public class Staff extends Person {
    public String role;

    public Staff(String name,String role) {
        super(name);
        this.role = role;
    }
    
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.err.println("Role : " + role);
    }
     
}
