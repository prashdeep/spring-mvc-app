package com.sapient.springdemo.service;

import com.sapient.springdemo.dao.EmployeeDAO;
import com.sapient.springdemo.model.Employee;
import com.sapient.springdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired( required = true)
    @Qualifier(value = "hibernateDAOImpl")
    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeRepository employeeRepository;


    /*public EmployeeServiceImpl(@Qualifier(value = "mysqlDAOImpl")EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }
    */
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public Employee saveEmployee(Employee employee) {
        System.out.println("Inside the save employee method of Employee service class ....");
        //return employeeDAO.save(employee);
         return employeeRepository.save(employee);
    }

    @Transactional
    public List<Employee> fetchAllEmployees() {
        return employeeDAO.listAll();
    }

    @Transactional
    public Employee findById(long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }
         throw new IllegalArgumentException("Employee Not Found");
    }

    @Transactional
    public void deleteEmployee(long id) {
        employeeDAO.deleteEmployee(id);
    }

    public Employee updateEmployee(long id, Employee employee){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee currentEmployee =  optionalEmployee.get();
            currentEmployee.setName(employee.getName());
            currentEmployee.setAge(employee.getAge());
            currentEmployee.setDependents(employee.getDependents());
            currentEmployee.setEmployeeDetails(employee.getEmployeeDetails());
            employeeRepository.save(currentEmployee);
        }
        throw new IllegalArgumentException("Employee Not Found");
    }
}