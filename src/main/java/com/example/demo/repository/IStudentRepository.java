package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByNameContaining(String name);
    @Query("SELECT s FROM Student AS s WHERE s.name LIKE CONCAT('%',:name,'%')")
    List<Student> findByNameStudent(@Param("name") String name);
    @Query("SELECT s FROM Student AS s WHERE s.birthDay >= :startDate AND s.birthDay <= :endDate")
    List<Student> listStudetBetweenDate(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
    List<Student> findAllByUserId(Long id);
}
