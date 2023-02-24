package com.studentmanagement.studentmanagement.repository;

import com.studentmanagement.studentmanagement.entity.Course;
import com.studentmanagement.studentmanagement.entity.CourseMaterial;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;


    @Test
    @DisplayName("Save course material using course")
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .CourseTitle("SWE-413")
                .Credit(5)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    @DisplayName("print all course materials")
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        System.out.println(courseMaterialList+"_-----------------all course materials without course----------------");
    }

}