package com.paypal.bfs.test.employeeserv.service;


import org.springframework.http.ResponseEntity;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

public interface EmployeeService {
	

	public ResponseEntity<Employee> employeeGetById(String id) ;

	public ResponseEntity<Employee> createEmployee(Employee employee);

}
