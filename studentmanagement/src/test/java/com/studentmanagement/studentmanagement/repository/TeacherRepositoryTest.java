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
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    @DisplayName("Save Teacher with course integrated")
    public void saveTeacher(){
        Course courseEng = Course.builder()
                .courseTitle("English")
                .credit(3)
                .build();

        Course courseBan = Course.builder()
                .courseTitle("Bangla")
                .credit(3)
                .build();

        Course courseIslam = Course.builder()
                .courseTitle("Islam")
                .credit(3)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Md Shah Alam")
                .lastName("Talukder")
//                .courses(List.of(courseEng,courseBan, courseIslam))
                .build();

        teacherRepository.save(teacher);
    }



}