package com.ys.project.entity;

import org.springframework.stereotype.Component;

@Component
public class UserInfo {
	private int id;
	private String user_name;
	private String password;
	private String login_name;
	private String is_locked;
	private String user_role;
	
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIs_locked() {
		return is_locked;
	}
	public void setIs_locked(String is_locked) {
		this.is_locked = is_locked;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	
	
}
