package com.springguides.springboot;

import com.springguides.springboot.model.Student;
import com.springguides.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
//		Student student = new Student();
//		student.setStuID(21);
//		student.setStuName("Shrinidhi");
//		student.setStuAge(24);
//		student.setStuHeight(6);
//		student.setStuWeight(65);
//		studentRepository.save(student);

	}
}
