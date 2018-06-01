package com.hebaohua.springbootjpa.controller;

import com.hebaohua.springbootjpa.entity.Employee;
import com.hebaohua.springbootjpa.repository.EmpoyeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmpoyeeRepository empoyeeRepository;

    @PostMapping("/addEmployee")
    public Employee addEmpoyee(@RequestBody Employee employee){
        empoyeeRepository.save(employee);
        return empoyeeRepository.getOne(employee.getId());
    }
}
