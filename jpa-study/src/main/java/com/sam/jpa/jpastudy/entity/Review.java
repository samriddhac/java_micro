package com.sam.jpa.jpastudy.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="Review")
public class Review {

	@Id
	@GeneratedValue
	private long id;
	private String rating;
	private String description;
	@CreationTimestamp
	private LocalDateTime dateCreated;
	@UpdateTimestamp
	private LocalDateTime dateUpdated;
	
	@ManyToOne
	private Course course;
	
	public Review() {}

	public Review(String rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}

	
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", description=" + description + ", dateCreated="
				+ dateCreated + ", dateUpdated=" + dateUpdated + "]";
	}
	
}
