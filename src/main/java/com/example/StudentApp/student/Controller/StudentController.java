package com.example.StudentApp.student.Controller;


import com.example.StudentApp.student.Entity.Student;

import com.example.StudentApp.student.Service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

@GetMapping("/getAllStudent")
    public List<Student> findAllStudents()
    {
        return studentService.findAllStudents();
    }

 @PostMapping("/saveStudent")
 public Student saveStudent(@RequestBody Student student)
 {
    return studentService.saveStudent(student);
 }

 @PutMapping ("/updateStudent")
    public Optional<Student> updateStudent(@RequestBody Student student)
 {
 return Optional.ofNullable(studentService.updateStudent(student));
 }

 @DeleteMapping("/deleteStudent/{id}")
    public boolean deleteStudent(@PathVariable String id)
 {
    return studentService.deleteStudent(id);
 }

}
