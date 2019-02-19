package com.sam.jpa.jpastudy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sam.jpa.jpastudy.entity.Course;
import com.sam.jpa.jpastudy.entity.Review;

@Transactional
@Repository
public class CourseRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;
	
	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(Long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}
	
	public Course save(Course course) {
		if(course.getId()==0L) {
			entityManager.persist(course);
		}
		else {
			entityManager.merge(course);
		}
		return course;
	}
	
	public void testEntityManagerFeatures() {
		Course course1 = new Course("React js");
		Course course2 = new Course("Anguler js");
		
		entityManager.persist(course1);
		entityManager.persist(course2);
		
		entityManager.flush();
		
		course1.setName("React js Part 1");
		entityManager.refresh(course1);
		entityManager.flush();
		
		
		entityManager.detach(course2);
		entityManager.clear(); //Does the same
		
		course2.setName("Anguler js Part 1");
		entityManager.flush();
	}
	
	public void jpqlQueries() {
		List resultList = entityManager.createQuery("select c from Course c")
				.getResultList();
		logger.info("data {}",resultList);
		
		List<Course> resultList2 = entityManager.createQuery("select c from Course c", Course.class)
				.getResultList();
		logger.info("data {}",resultList2);
		
		List<Course> resultList3 = entityManager.createQuery("select c from Course c where name like '%Part%'", Course.class)
				.getResultList();
		logger.info("data {}",resultList3);
		
		List resultList4 = entityManager.createNamedQuery("query_all_course")
				.getResultList();
		logger.info("data {}",resultList4);
		
		Query query = entityManager.createNativeQuery("select * from course  where id=:id", Course.class);
		query.setParameter("id", 10003L);
		List<Course> resultList5 = query.getResultList();
		logger.info("data {}",resultList5);
		
	}
	
	public void addReviewsToCourse(Long courseId, List<Review> reviews) {
		Course course = entityManager.find(Course.class, courseId);
		reviews.forEach((review)->{
			course.addReview(review);
			review.setCourse(course);
			entityManager.persist(review);
		});
	}
}
