package com.rootspringproject;

//libraries
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope(scopeName = "singleton")
//@Scope(scopeName = "prototype")
@Scope(scopeName = "singleton")
public class Student {

    public String grade;

    private String name;
//    private Teacher teacher;


    public Student(){
//        this.teacher = teacher;
    }
    public Student(String name){
        this.setName(name);
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void learning () {
        System.out.println("Hello I am learning");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Post construct method is called");
    }


    @PreDestroy
    public void preDestroy(){
        System.out.println("Pre Destroy method is called");
    }
}
