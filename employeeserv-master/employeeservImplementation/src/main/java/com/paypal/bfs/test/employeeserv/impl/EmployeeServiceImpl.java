package com.paypal.bfs.test.employeeserv.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dao.AddressDAO;
import com.paypal.bfs.test.employeeserv.dao.EmployeeDAO;
import com.paypal.bfs.test.employeeserv.exception.EmployeeAlreadyExistsException;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Autowired
	private AddressDAO addressDao;

	@Override
	public ResponseEntity<Employee> employeeGetById(String id) {
		Employee employee = dao.findById(Integer.parseInt(id)).get();
		employee.getAddress().setId(null);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Employee> createEmployee(Employee employee) {
		if (dao.existsById(employee.getId())) {
			throw new EmployeeAlreadyExistsException(
					"Can't create a new employee. An employee with id " + employee.getId() + " already exists.");
		}
		Address address = employee.getAddress();
		address.setId(employee.getId());
		addressDao.save(address);
		dao.save(employee);
		employee.getAddress().setId(null);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}

}
