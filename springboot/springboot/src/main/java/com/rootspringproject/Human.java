package com.rootspringproject;

import org.springframework.context.annotation.Scope;

@Scope(scopeName = "singleton")
public class Human implements Behave {

    private String name;
    private String email;
    private String phone;
    private Student student;

    public Human(){

    }

    public Human(Student student){
        this.student = student;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", student=" + student +
                '}';
    }


    @Override
    public String behaviour() {
        return this.name+" "+this.email+ " " + this.phone;
    }
}
