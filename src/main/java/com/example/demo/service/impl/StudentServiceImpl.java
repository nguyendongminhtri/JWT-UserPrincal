package com.example.demo.service.impl;

import com.example.demo.model.Student;
import com.example.demo.model.User;
import com.example.demo.repository.IStudentRepository;
import com.example.demo.security.userprincal.UserDetailsServiceImpl;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        User user = userDetailsService.getCurrentUser();
        student.setUser(user);
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAllByNameContaining(String name) {
        return studentRepository.findAllByNameContaining(name);
    }

    @Override
    public List<Student> findByNameStudent(String name) {
        return studentRepository.findByNameStudent(name);
    }

    @Override
    public List<Student> listStudetBetweenDate(LocalDate startDate, LocalDate endDate) {
        return studentRepository.listStudetBetweenDate(startDate,endDate);
    }

    @Override
    public List<Student> findAllByUserId(Long id) {

        return studentRepository.findAllByUserId(id);
    }
}
