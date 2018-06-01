package com.hebaohua.springbootjpa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private long id;

    @ManyToMany
    @JoinTable(name = "project_employee_link", joinColumns = {
            @JoinColumn(name = "project_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "employee_id", referencedColumnName = "id")})
    private Collection<Employee> employees;

    private String projName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }
}
