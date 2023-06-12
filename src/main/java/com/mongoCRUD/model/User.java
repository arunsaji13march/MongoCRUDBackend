package com.mongoCRUD.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "User")
public class User {
	
	@Id
	int id;
	String name;
	int age;
	String email;
	
	@Field("sex")
	Gender sex;
	String job;
	List<String> friends;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Gender getSex() {
		return sex;
	}
	public void setSex(Gender sex) {
		this.sex = sex;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public List<String> getFriend() {
		return friends;
	}
	public void setFriend(List<String> friends) {
		this.friends = friends;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", sex=" + sex + ", job="
				+ job + ", friends=" + friends + "]";
	}
	
	
	
	
}
