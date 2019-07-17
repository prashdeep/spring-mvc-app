package com.sapient.springdemo.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement (name = "employee")
@XmlAccessorType(XmlAccessType.NONE)
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private  long id;

    @NotEmpty
    @XmlAttribute
    private  String name;
    @NotNull
    @Range(min = 18, max = 58, message = "Age should be between 18 and 58")
    @XmlAttribute
    private  int age;
    @NotNull
    @Range(min =20000, max = 50000, message = "Salary should be between 20000 and 50000")
    @XmlAttribute
    private double salary;

    public Employee(){

    }

    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}