package com.example.StudentApp.student.Service;

import com.example.StudentApp.student.Entity.Student;
import com.example.StudentApp.student.Repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class StudentServiceImpl {

    @Autowired
    private StudentRepository STUDENT_REPOSITORY;

    public List<Student> findAllStudents()
    {
        return STUDENT_REPOSITORY.findAll();
    }

    public Student saveStudent(Student student)
    {
        return STUDENT_REPOSITORY.save(student);
    }


    public Student updateStudent(Student student)
    {
        Student s = new Student();
        Optional<Student> student1 = STUDENT_REPOSITORY.findById(student.getId());
        log.info("Student found with Id" + student.getId() + " " + student1.get());
        s.setId(student.getId());
        s.setName(student.getName());
        s.setEmail(student.getEmail());
        s.setMobile(student.getMobile());
        return saveStudent(s);

    }

    public boolean deleteStudent(String id) {

        STUDENT_REPOSITORY.deleteById(Long.valueOf(id));
        if(STUDENT_REPOSITORY.findById(Long.valueOf(id)) == null)
        {
            return false;
        }
        else return true;


    }
}
