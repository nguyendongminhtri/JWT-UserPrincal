package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.User;
import com.example.demo.security.userprincal.UserDetailsServiceImpl;
import com.example.demo.service.impl.StudentServiceImpl;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    UserServiceImpl userService;
    @GetMapping()
    public ResponseEntity<?> listStudent(){
        List<Student> students = studentService.findAll();
        if(students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchByName(@Param("name") String name){
        List<Student> students = studentService.findAllByNameContaining(name);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/search/between/date")
    public ResponseEntity<?> searchBetWeenDate(@RequestParam("startDate") LocalDate startDate, @RequestParam("endDate")LocalDate endDate){
        List<Student> students = studentService.listStudetBetweenDate(startDate,endDate);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/search-by-user/{id}")
    public ResponseEntity<?> findByUser(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        List<Student> studentList = studentService.findAllByUserId(user.get().getId());
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }


}
