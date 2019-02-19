package com.sam.microservice.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {

	@Id
	private long id;
	private String name;
	
	@OneToOne
	private Group group;
	
	public User() {
		super();
	}

	public User(long id, String name, Group group) {
		super();
		this.id = id;
		this.name = name;
		this.group = group;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", group=" + group + "]";
	}
	
}
