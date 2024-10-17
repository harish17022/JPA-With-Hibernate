package com.hibernateDemo.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hibernateDemo.DAO.StudentDao;
import com.hibernateDemo.entity.Student;

@RestController
public class StudentController {

	@Autowired
	private StudentDao studentDao;
	
	@PostMapping("/students")
	public String addStudent(@RequestBody Student stu) {
		studentDao.save(stu);
		return "Student Saved Successully";
		
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		return studentDao.findById(studentId);
		
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentDao.findAll();
		
	}
	
	@PutMapping("/students")
	public String Updating(@RequestBody Student stu) {
		studentDao.update(stu);
		return "Student Updated Successully";
		
	}
	
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {
		studentDao.deleteById(studentId);
		return "Student with id= "+studentId+" Deleted Successfully";
		
	}
	
	
}
