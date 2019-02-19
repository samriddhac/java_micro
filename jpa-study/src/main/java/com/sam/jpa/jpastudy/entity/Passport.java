package com.sam.jpa.jpastudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Passport")
public class Passport {

	@Id
	@GeneratedValue
	private long id;
	@Column(name="number", nullable=false, length=200, unique=true, updatable=true, insertable=true)
	private String number;

	@OneToOne(fetch=FetchType.LAZY, mappedBy="passport")
	private Student student;
	
	public Passport() {}

	public Passport(String number) {
		super();
		this.number = number;
	}

	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public long getId() {
		return id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}
	
	
}
