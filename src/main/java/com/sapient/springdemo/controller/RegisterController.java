package com.sapient.springdemo.controller;

import com.sapient.springdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String registerEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "register";
    }


}