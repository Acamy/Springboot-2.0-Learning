package com.hebaohua.springbootjpa.repository;

import com.hebaohua.springbootjpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpoyeeRepository extends JpaRepository<Employee, Long> {
}
