package com.studentmanagement.studentmanagement.repository;

import com.studentmanagement.studentmanagement.entity.Course;
import com.studentmanagement.studentmanagement.entity.Student;
import com.studentmanagement.studentmanagement.entity.Teacher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;

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
                .courseTitle("Math")
                .credit(5)
//                .courseMaterial()
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    @DisplayName("Records with pagination")
    public void findAllPagination(){
        Pageable firstPageWithTwoRecords = PageRequest.of(0,2);
        Pageable secondPageWithOneRecords = PageRequest.of(1, 1);

        List<Course> courseList = courseRepository.findAll(firstPageWithTwoRecords).getContent();
        System.out.println(courseList+"course list with first page record");
        System.out.println(courseList.size()+"size of the records");


        List<Course> courseList2 = courseRepository.findAll(secondPageWithOneRecords).getContent();
        System.out.println(courseList2+"course list with second page record");
        System.out.println(courseList2.size()+"size of the records two");


        long totalElements = courseRepository.findAll(firstPageWithTwoRecords).getTotalElements();
        long totalPages = courseRepository.findAll(firstPageWithTwoRecords).getTotalPages();
        System.out.println(totalElements+"total number of elements");
        System.out.println(totalPages+"total number of pages");

    }


    @Test
    @DisplayName("find all records with pagination and sorting")
    public void getRecordsWithPaginationAndSorting(){
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("courseTitle"));

        Pageable sortByCredit = PageRequest.of(0,5,Sort.by("credit").descending());

        List<Course> coursesSortedByTitle = courseRepository.findAll(sortByTitle).getContent();
        System.out.println(coursesSortedByTitle+"courses sorted by title");

        List<Course> coursesSortedByCredit = courseRepository.findAll(sortByCredit).getContent();
        System.out.println("coursesSortedByCredit = " + coursesSortedByCredit);
    }
    @Test
    @DisplayName("Get records contains given character with pagination")
    public void getRecordsContainingWithPagination(){
        Pageable paginate = PageRequest.of(0,2);
        List<Course> courses = courseRepository.findByCourseTitleContaining("M",paginate).getContent();
        System.out.println("courses = " + courses);
    }


    @Test
    @DisplayName("save Course  Student and Teacher")
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("ATM1")
                .lastName("Edris")
                .build();

        Student student = Student.builder()
                .firstName("New")
                .lastName("Man")
                .emailId("newman@gmail.com")
                .build();

        Course course = Course.builder()
                .courseTitle("Physics")
                .credit(3)
                .teacher(teacher)
                .build();

        course.addStudent(student);
        courseRepository.save(course);
    }
    @Test
    @DisplayName("Find all course containing teacher and students")
    public void findAllCourseContainingTeacherAndStudent(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

}