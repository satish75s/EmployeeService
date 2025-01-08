package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		log.info("addEmployee is called in controller");
		return employeeService.addEmployee(employee);
	}

	@GetMapping("/fetchList")
	public List<Employee> getEmpList() {
		log.info("return emp list in controller");
		return employeeService.getEmpList();
	}
    
	@GetMapping("/fetchById/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}
    
	@DeleteMapping("/deleteById/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
	}
    
	@PutMapping("/updateById/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
		return employeeService.updateEmployee(id, updatedEmployee);

	}
}
