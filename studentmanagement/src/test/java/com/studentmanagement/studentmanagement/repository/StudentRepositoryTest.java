package com.studentmanagement.studentmanagement.repository;

import com.studentmanagement.studentmanagement.entity.Guardian;
import com.studentmanagement.studentmanagement.entity.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository  studentRepository;

    @Test
    @DisplayName("Student Object Save")
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("shahedtalukder522@gmail.com")
                .firstName("Shahed")
                .lastName("Talukder")
//                .guardianName("Shah Alam Talukder")
//                .guardianEmail("shahalam.tghs@gmail.com")
//                .guardianMobile("01725156222")
                .build();

        studentRepository.save(student);
    }

    @Test
    @DisplayName("Store Student with guardian name")
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("ATM")
                .email("atm@gmail.com")
                .mobile("01710952383")
                .build();



        Student student = Student.builder()
                .firstName("Ashik")
                .lastName("Miah")
                .emailId("ashik@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    @DisplayName("Print All Student")
    public void getAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList+"--------------student list-------------");
    }


    @Test
    @DisplayName("Find By First Name")
    public void findStudentByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Shahed");
        System.out.println(studentList+"--------get----------");
    }

    @Test
    @DisplayName("Find By First Name Containing")
    public void findStudentByFirstNameContainingChars(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("hed");
        System.out.println(studentList+"--------get containing----------");
    }

    @Test
    @DisplayName("Find by last name not null")
    public void findByLastNameNotNull(){
        List<Student> studentList = studentRepository.findByLastNameNotNull();
    }

    @Test
    @DisplayName("Find by guardian name")
    public void findByGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianNameIgnoreCaseContaining("atm");
        System.out.println("by guardian name"+studentList);
    }


//    this test case is written with jpql query
    @Test
    @DisplayName("Find by email address")
    public void findStudentByEmailId(){
        Student student = studentRepository.getStudentByEmailAddress("shahedtalukder522@gmail.com");
        System.out.println(student+"----find by email address");
    }
}