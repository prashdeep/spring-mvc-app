package com.sapient.springdemo.controller;

import com.sapient.springdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping("/employee")
public class RegisterController {

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @GetMapping("/listAll")
    public String displayAllEmployees(Model model){
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Vinay"));
        empList.add(new Employee(2, "Harish"));
        model.addAttribute("empList", empList);
        return "display";
    }

    @GetMapping("/{id}")
    public String displayEmployee(@PathVariable("id") int id,  Model model){

        Employee employee = new Employee(id, "Vinay");

        model.addAttribute("employee", employee);
        return "employee";
    }

    @GetMapping("/register")
    public String registrationPage(Model model){
        model.addAttribute("employee", new Employee());
        return "register";
    }

    @PostMapping("/register")
    public String registerEmployee(){
        System.out.println("Came inside the post method of register employee ....");
        return "success";
    }


}