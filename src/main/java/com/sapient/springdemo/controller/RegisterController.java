package com.sapient.springdemo.controller;

import com.sapient.springdemo.model.Employee;
import javafx.application.Application;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.ArrayList;

//@Controller
@RestController
@RequestMapping("/employees")
public class RegisterController {

    /*@GetMapping("/login")
    public String login(){

        return "login";
    }*/

    @GetMapping(value = "/", produces = {"application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> displayAllEmployees(){
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Vinay"));
        empList.add(new Employee(2, "Harish"));
        //model.addAttribute("empList", empList);
        return empList;
    }

    @GetMapping(value = "/{id}", produces = {"application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public Employee displayEmployee(@PathVariable("id") int id){

        Employee employee = new Employee(id, "Vinay");

        return employee;
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

    @PostMapping(value = "/", consumes = "application/xml")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerEmployee(@Valid @RequestBody Employee employee){
        System.out.println(employee);

        System.out.println("Came inside the post method of register employee ....");


    }



}