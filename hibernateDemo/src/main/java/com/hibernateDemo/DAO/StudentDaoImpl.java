package com.hibernateDemo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernateDemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private EntityManager entityManager;
	
	
	
	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
		
	}



	@Override
	public Student findById(int id) {
		
		return entityManager.find(Student.class, id);
	}



	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);
		List<Student> students = query.getResultList();
		return students;
	}



	@Override
	@Transactional
	public void update(Student student) {

		entityManager.merge(student);
	}



	@Override
	@Transactional
	public void deleteById(int id) {

		Student find = entityManager.find(Student.class, id);
		entityManager.remove(find);
	}

}
