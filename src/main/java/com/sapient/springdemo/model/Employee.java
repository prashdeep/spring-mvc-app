package com.sapient.springdemo.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

    @NotEmpty
    @XmlElement(name = "NAME")
    @Column(name="emp_name")
    private  String name;
    @NotNull
    @Range(min = 18, max = 58, message = "Age should be between 18 and 58")
    @XmlElement
    @Column(name="emp_age")
    private  int age;

    @NotNull
    @Range(min =20000, max = 50000, message = "Salary should be between 20000 and 50000")
    @XmlElement
    @Column(name="emp_salary")
    private double salary;

    public Employee(){

    }

    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
    }

}