package com.api.demo.employee.employee_api;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.demo.employee.employee_api.models.Employee;
import com.api.demo.employee.employee_api.models.EmployeeNotFoundException;
import com.api.demo.employee.employee_api.repositories.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@GetMapping("/all")
	public List<Employee> getAllEmployees(){

		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable ObjectId id) {
		Employee emp =  repository.findBy_id(id);
		if(emp == null)
			throw new EmployeeNotFoundException();

		else
			return emp;
	}

	@GetMapping("/findbyempid")
	public Employee getEmployeeByEmpId(@RequestParam(value="empid") Long empId){
		Employee emp = repository.findByempId(empId);
		
		if(emp == null)
			throw new EmployeeNotFoundException();

		else
			return emp;
	}

	@GetMapping("/findbyname")
	public Employee getEmployeeByName(@RequestParam(value="empname") String name) {
		//return repository.findByName(name);

		return repository.findByNameQuery(name);
	}

	@GetMapping("/findbyemail")
	public Employee getEmployeeByEmail(@RequestParam(value="email") String email) {
		//return repository.findByName(name);

		return repository.findByEmailQuery(email);
	}

	@PostMapping
	public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		employee.set_id(ObjectId.get());
		repository.save(employee);
		return employee;
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable ObjectId id) {

		repository.delete(repository.findBy_id(id));
	}

}
