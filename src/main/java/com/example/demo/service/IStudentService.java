package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> findAll();
    Student save(Student student);
    Optional<Student> findById(Long id);
    void deleteById(Long id);
    List<Student> findAllByNameContaining(String name);
    List<Student> findByNameStudent(@Param("name") String name);
    List<Student> listStudetBetweenDate(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
    List<Student> findAllByUserId(Long id);
}
