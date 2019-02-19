package com.sam.jpa.jpastudy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sam.jpa.jpastudy.entity.Passport;
import com.sam.jpa.jpastudy.entity.Student;

@Transactional  //--This creates a persistance context (equivalent to hibernate session. EntityManager equivalent to hibernate session factory.)
@Repository
public class StudentRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;
	
	public Student findById(Long id) {
		Student student = entityManager.find(Student.class, id);
		student.setPassport(student.getPassport());
		logger.info("Student {}", student);
		return student;
	}
	
	
	public void understandPersistantContext() {
		Student student = entityManager.find(Student.class, 20001L);
		//persistance context (student)
		Passport passport = student.getPassport();
		//persistance context (student, passport)
		student.setName("James Mcvoy");
		//persistance context (student updated, passport)
		passport.setNumber("W0987654321");
		//persistance context (student updated, passport updated)
		
		/**
		 * The database changes will be fired at the end of the method.
		 */
	}
	
	public void testPassportBiDirectional() {
		Passport passport = entityManager.find(Passport.class, 30002L);
		logger.info("Passport {}", passport);
		logger.info("Student {}", passport.getStudent());
	}
	
	
	
	public void deleteById(Long id) {
		Student student = findById(id);
		entityManager.remove(student);
	}
	
	public Student save(Student student) {
		if(student.getId()==0L) {
			entityManager.persist(student);
		}
		else {
			entityManager.merge(student);
		}
		return student;
	}
	
	public Student saveStudentWithPassport() {
		Student student = new Student("Samriddha");
		Passport passport = new Passport("J0103190");
		entityManager.persist(passport);
		
		student.setPassport(passport);
		entityManager.persist(student);
		return student;
	}
	
	public void testEntityManagerFeatures() {
		Student student1 = new Student("React js");
		Student student2 = new Student("Anguler js");
		
		entityManager.persist(student1);
		entityManager.persist(student2);
		
		entityManager.flush();
		
		student1.setName("React js Part 1");
		entityManager.refresh(student1);
		entityManager.flush();
		
		
		entityManager.detach(student2);
		entityManager.clear(); //Does the same
		
		student2.setName("Anguler js Part 1");
		entityManager.flush();
	}
	
	public void jpqlQueries() {
		List resultList = entityManager.createQuery("select c from Student c")
				.getResultList();
		logger.info("data {}",resultList);
		
		List<Student> resultList2 = entityManager.createQuery("select c from Student c", Student.class)
				.getResultList();
		logger.info("data {}",resultList2);
		
		List<Student> resultList3 = entityManager.createQuery("select c from Student c where name like '%Part%'", Student.class)
				.getResultList();
		logger.info("data {}",resultList3);
		
		List resultList4 = entityManager.createNamedQuery("query_all_Student")
				.getResultList();
		logger.info("data {}",resultList4);
		
		Query query = entityManager.createNativeQuery("select * from Student  where id=:id", Student.class);
		query.setParameter("id", 10003L);
		List<Student> resultList5 = query.getResultList();
		logger.info("data {}",resultList5);
		
	}
}
