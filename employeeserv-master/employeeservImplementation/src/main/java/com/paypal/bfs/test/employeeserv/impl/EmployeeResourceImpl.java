package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

	@Autowired
	private EmployeeService service;

	@Override
	public ResponseEntity<Employee> employeeGetById(String id) {
		return service.employeeGetById(id);
		
	}

	@Override
	public ResponseEntity<Employee> createEmployee(Employee employee) {
		return service.createEmployee(employee);
	}
}
