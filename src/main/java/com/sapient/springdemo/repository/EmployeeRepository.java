package com.sapient.springdemo.repository;

import com.sapient.springdemo.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("empRepository")
public interface EmployeeRepository extends CrudRepository< Employee, Long> {
}