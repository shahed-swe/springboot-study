package com.studentmanagement.studentmanagement.repository;

import com.studentmanagement.studentmanagement.entity.Course;
import com.studentmanagement.studentmanagement.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseEng = Course.builder()
                .CourseTitle("English")
                .Credit(3)
                .build();

        Course courseBan = Course.builder()
                .CourseTitle("Bangla")
                .Credit(3)
                .build();

        Course courseIslam = Course.builder()
                .CourseTitle("Islam")
                .Credit(3)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Md Shah Alam")
                .lastName("Talukder")
//                .courses(List.of(courseEng,courseBan, courseIslam))
                .build();

        teacherRepository.save(teacher);
    }



}