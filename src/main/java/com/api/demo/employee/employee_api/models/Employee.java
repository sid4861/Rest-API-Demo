package com.api.demo.employee.employee_api.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Employee details - employee ID, name, email")
public class Employee {

	@Id
	public ObjectId _id;
	
	//@Size(min=1, message="Size should have at least 1 digit")
	@ApiModelProperty(notes="Size should have at least 1 digit")
	public Long empId;
	
	@Size(min=2, message="name should have at least 2 characters")
	@ApiModelProperty(notes="name should have at least 2 characters")
	public String name;
	
	//@Email(message="The string has to be a well-formed email address")
	@ApiModelProperty(notes="The string has to be a well-formed email address")
	public String email;

	public Employee() {

	}

	public Employee(Long empId, String name, String email) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
	}

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", email=" + email + "]";
	}




}
