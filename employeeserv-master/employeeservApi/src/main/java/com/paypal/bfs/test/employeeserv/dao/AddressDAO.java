package com.paypal.bfs.test.employeeserv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.paypal.bfs.test.employeeserv.api.model.Address;


public interface AddressDAO extends JpaRepository<Address, Integer> {

}
