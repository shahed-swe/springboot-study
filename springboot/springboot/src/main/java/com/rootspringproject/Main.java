package com.rootspringproject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

//
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Teacher t1 = context.getBean(Teacher.class);
        t1.teach();
        System.out.println(t1);
//        System.out.println( t1.getQualification());


        Student s1 = context.getBean(Student.class);
        s1.learning();
        s1.setName("Shahed Talukder");
        System.out.println(s1);


        Student s2 = context.getBean(Student.class);
        System.out.println(s2);


//        Stuff stuff = context.getBean(Teacher.class);
//        stuff.work();





    }
}