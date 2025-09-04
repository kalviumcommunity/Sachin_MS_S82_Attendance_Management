package com.school;


public class Person {
    static private int nextIdCounter = 0;
    protected int id;
    protected String name;

    public Person(String name) {
        id = nextIdCounter++;    
        this.name = name;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void displayDetails(){
        System.out.println("Id: "+getId()+" Name: "+getName());
    }
}
