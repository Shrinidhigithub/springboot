package com.springguides.springboot.controller;

import com.springguides.springboot.Exception.ResourceNotFoundException;
import com.springguides.springboot.model.Student;
import com.springguides.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //create a RestAPI//
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    //Build GET Student ID by REST API//
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:" + id));
        return ResponseEntity.ok(student);
    }

    //Build UPDATE Student Rest API//
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student studentDetails)
        {
            Student updateStudent = studentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Student not Exist with id: " + id));

        updateStudent.setName(studentDetails.getName());
        updateStudent.setAge(studentDetails.getAge());
        updateStudent.setHeight(studentDetails.getHeight());
        updateStudent.setWeight(studentDetails.getWeight());

        studentRepository.save(updateStudent);

        return ResponseEntity.ok(updateStudent);
    }

    //DELETE Student Rest API//
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not Exist with id: " + id));

        studentRepository.delete(student);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
