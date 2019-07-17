package com.sapient.springdemo.controller;

import com.sapient.springdemo.model.Employee;
import com.sapient.springdemo.model.EmployeeList;
import com.sapient.springdemo.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

//@Controller
@RestController
public class RegisterController {

    @Autowired
    private EmployeeService employeeService;

    /*@GetMapping("/login")
    public String login(){

        return "login";
    }*/

    @GetMapping(value = "/employees", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ApiOperation(value = "Fetch all employees", notes = "API to fetch all the employees")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeList displayAllEmployees(){
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Vinay"));
        empList.add(new Employee(2, "Harish"));
        //model.addAttribute("empList", empList);
        EmployeeList employeeList = new EmployeeList();
        employeeList.setEmployees(empList);
        return employeeList;
    }

    @GetMapping(value = "/employees/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.OK)
    public Employee displayEmployee(
            @ApiParam(value = "${EmployeeController.getEmployeeById}", required = true)
            @PathVariable("id") int id){

        Employee employee = new Employee(id, "Vinay");

        return employeeService.findById(id);
    }

    /*@GetMapping("/register")
    public String registrationPage(Model model){
        model.addAttribute("employee", new Employee());
        return "register";
    }*/

    /*@PostMapping("/register")
    public String registerEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result){
        System.out.println(employee);

        System.out.println("Came inside the post method of register employee ....");
        if(result.hasErrors()){
            return "register";
        }
        return "success";
    }*/

    @PostMapping(value = "/employees", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public void registerEmployee(@Valid @RequestBody Employee employee){
        System.out.println(employee);
        employeeService.saveEmployee(employee);
        System.out.println("Came inside the post method of register employee ....");
    }



}