package com.sam.jpa.jpastudy.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="Student")
public class Student {

	@Id
	@GeneratedValue
	private long id;
	@Column(name="name", nullable=false, length=200, unique=true, updatable=true, insertable=true)
	private String name;
	@CreationTimestamp
	private LocalDateTime dateCreated;
	@UpdateTimestamp
	private LocalDateTime dateUpdated;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Passport passport;
	
	public Student() {}

	public Student(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated
				+ ", passport=" + passport + "]";
	}

	
	
	
}
