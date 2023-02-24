package com.studentmanagement.studentmanagement.repository;

import com.studentmanagement.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String firstName);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianNameIgnoreCaseContaining(String guardianName);


    //JPQL Query
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getFirstNameByEmailAddress(String emailId);

    @Query("select s from Student s where s.guardian.email = ?1 and s.emailId = ?2")
    Student findByGuardianEmailAndStudentEmail(String GuardianEmail, String emailId);

    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);


    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(String emailId);

//    from now we will create test case for updating data
    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name = :firstName where email_address = :emailId",nativeQuery = true)
    int UpdateStudentnameByEmailid(String firstName, String emailId);

}
