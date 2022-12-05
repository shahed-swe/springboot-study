package com.rootspringproject;


import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

//@Component
public class Teacher implements Stuff, BeanNameAware {

    private String qualification = "MBBS";
//    private Student student;
//    @Autowired
//    public Teacher(String qualification){
//        this.qualification = qualification;
//    }

    public void teach(){
        System.out.println("Teacher is teaching");
    }

    public void work(){
        System.out.println("Hello this is for you to work");
    }

//    @Bean
    public String getQualification() {
        return "Hello this is your qualification "+qualification;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("Set bean name method is called");
    }
//
//    public void setQualification(String qualification) {
//        this.qualification = qualification;
//    }

}
