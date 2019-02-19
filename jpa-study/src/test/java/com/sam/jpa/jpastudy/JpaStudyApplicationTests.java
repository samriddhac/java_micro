package com.sam.jpa.jpastudy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.sam.jpa.jpastudy.entity.Course;
import com.sam.jpa.jpastudy.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaStudyApplication.class)
public class JpaStudyApplicationTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;
	
	@Test
	public void contextLoads() {
		logger.info("Context Loaded");
	}
	
	@Test
	public void findById_test_1() {
		Course course = repository.findById(10002L);
		assertNotNull(course);
	}
	
	@Test
	@DirtiesContext
	public void deleteById_test_1() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
	}
	
	@Test
	public void save_test_1() {
		Course course = repository.findById(10002L);
		assertNotNull(course);
		
		course.setName("JPA Part 1--Updated");
		course = repository.save(course);
		course = repository.findById(10002L);
		assertEquals("JPA Part 1--Updated", course.getName());
		
	}
}
