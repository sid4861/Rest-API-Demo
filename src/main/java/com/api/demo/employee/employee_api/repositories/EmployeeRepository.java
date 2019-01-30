package com.api.demo.employee.employee_api.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.api.demo.employee.employee_api.models.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

	Employee findBy_id(ObjectId _id)
	Employee findByempId(Long empId);
	
	 @Query("{name : ?0}")
	 public Employee findByNameQuery(String name);
	 
	 @Query("{email : ?0}")
	 public Employee findByEmailQuery(String email);
	 
	 
}
