package com.hebaohua.springbootjpa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    private Cubicle cubicle;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    @ManyToMany(mappedBy = "employees", cascade = CascadeType.ALL)
    private Collection<Project> projects;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cubicle getCubicle() {
        return cubicle;
    }

    public void setCubicle(Cubicle cubicle) {
        this.cubicle = cubicle;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }
}
