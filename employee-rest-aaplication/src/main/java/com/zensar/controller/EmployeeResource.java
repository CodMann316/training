package com.zensar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.Employee;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeResource {

	public List<Employee> employees = new ArrayList<>();

	public EmployeeResource() {

		employees.add(new Employee(1001, "Ram", 3000));
		employees.add(new Employee(1002, "Rajiv", 4400));
		employees.add(new Employee(1003, "Rakesh", 3500));
		employees.add(new Employee(1004, "Raju", 200));
	}

	@GetMapping("/employees")
	public List<Employee> getEmployee() {
		return employees;
	}

	@PostMapping("/insert")
	public void insertEmployee(@RequestBody Employee employee) {
		employees.add(employee);
	}
	
	@GetMapping("/get/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {

		for(Employee e:employees)
			if(e.getEmployeeId()==employeeId)
				return e;
		return null;
	}

	@DeleteMapping("/delete/{employeeId}")
	public void insertEmployee(@PathVariable int employeeId) {
		System.out.println("WORLIND !!!");
		for (int i = 0; i < employees.size(); i++)
			if (employees.get(i).getEmployeeId() == employeeId)
				employees.remove(i);
	}

	@PatchMapping("/update")
	public void updateEmployee(@RequestBody Employee employee) {
		System.out.println("WORLIND !!!");
		for (int i = 0; i < employees.size(); i++)
			if (employees.get(i).getEmployeeId() == employee.getEmployeeId())
				employees.set(i, employee);
	}

	
}
