package com.studentmanagement.studentmanagement.repository;

import com.studentmanagement.studentmanagement.entity.Course;
import com.studentmanagement.studentmanagement.entity.Teacher;
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

    @Test
    @DisplayName("Save Course with a teacher")
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("ATM")
                .lastName("Edris")
                .build();

        Course course = Course.builder()
                .CourseTitle("Math")
                .Credit(5)
//                .courseMaterial()
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}