package com.sam.jpa.jpastudy;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sam.jpa.jpastudy.entity.Course;
import com.sam.jpa.jpastudy.entity.Review;
import com.sam.jpa.jpastudy.entity.Student;
import com.sam.jpa.jpastudy.repository.CourseRepository;
import com.sam.jpa.jpastudy.repository.StudentRepository;

@SpringBootApplication
public class JpaStudyApplication implements CommandLineRunner{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaStudyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = courseRepository.findById(10001L);
		logger.info("Cource {} ", course);
		courseRepository.deleteById(10001L);
		courseRepository.save(new Course("Micro Services Part 1"));
		
		courseRepository.testEntityManagerFeatures();
		courseRepository.jpqlQueries();
		studentRepository.saveStudentWithPassport();
		
		Student st = studentRepository.findById(20001L);
		logger.info("Passport {}",st.getPassport());
		
		studentRepository.understandPersistantContext();
		studentRepository.testPassportBiDirectional();
		
		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("4", "Good"));
		reviews.add(new Review("2", "Ok"));
		courseRepository.addReviewsToCourse(10005L, reviews);
	}
}
