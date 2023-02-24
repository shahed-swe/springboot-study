package com.studentmanagement.studentmanagement.repository;

import com.studentmanagement.studentmanagement.entity.Course;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    @DisplayName("Get all courses with it's materials")
    public void getAllCourse(){
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses+"---all courses with it's materials");
    }

}