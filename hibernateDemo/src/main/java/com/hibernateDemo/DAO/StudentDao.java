package com.hibernateDemo.DAO;

import java.util.List;

import com.hibernateDemo.entity.Student;

public interface StudentDao {

	public void save(Student student);
	
	public Student findById(int id);
	
	public List<Student> findAll();
	
	public void update(Student student);
	
	public void deleteById(int id);
}
