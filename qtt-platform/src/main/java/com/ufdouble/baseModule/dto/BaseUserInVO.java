package com.ufdouble.baseModule.dto;


import com.kcfy.platform.server.kernal.model.JInputModel;

public class BaseUserInVO   implements JInputModel {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	 private int age;
	 private String password;
	 private String sex;
	 private String phone;
	 private String email;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
