package com.sam.employeemanager.repo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.employeemanager.exception.UserNotFoundException;
import com.sam.employeemanager.model.Employee;
import com.sam.employeemanager.repo.EmployeeRepo;

@Service
public class EmployeeService {
	private final EmployeeRepo employeerepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeerepo) { 
		this.employeerepo = employeerepo;
	}
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeerepo.save(employee );
	}
	
	public List<Employee> findAllEmployees() {
		return employeerepo.findAll();
	}
	
	public Employee updateEmployee(Employee employee){
		return employeerepo.save(employee);
	}
	
	public void deleteEmployee(Long id) {
		employeerepo.deleteEmployeeById(id);
	}
   
	public Employee findEmployeeById(Long id) {
		return employeerepo.findEmployeeById(id)
				.orElseThrow(()-> new UserNotFoundException("User by id"+id+"not found."));
				
	}
   }
	
	
