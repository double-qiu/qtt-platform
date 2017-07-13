package com.ufdouble.baseModule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.kcfy.platform.server.kernal.model.AbstractEntity;
import com.kcfy.platform.server.kernal.model.JInputModel;
import com.kcfy.platform.server.kernal.model.JOutputModel;

@Entity
@Table(name = "base_user")
public class BaseUser  extends AbstractEntity implements JInputModel, JOutputModel {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="name", length=200)
	private String name;
	@Column(name="age", length=8)
  	private int age;
	@Column(name="password", length=200)
	private String password;
	@Column(name="sex", length=200)
	private String sex;
	@Column(name="phone", length=200)
	private String phone;
	@Column(name="email", length=200)
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
