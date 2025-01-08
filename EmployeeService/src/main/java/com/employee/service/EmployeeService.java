package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		log.info("addEmployee is called");
		return employeeRepository.save(employee);
	}

	public List<Employee> getEmpList() {
		log.info("return emp list");
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployeeById(int id) {
		return employeeRepository.findById(id);
	}

	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	public Employee updateEmployee(int id, Employee updatedEmployee) {
		Optional<Employee> existingEmployee = employeeRepository.findById(id);
		if (existingEmployee.isPresent()) {
			updatedEmployee.setId(id);
			return employeeRepository.save(updatedEmployee);
		}
		return null;
	}
}
