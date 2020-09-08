package com.jc.entity;

import java.io.Serializable;
import java.util.List;

public class DepartmentEmp implements Serializable {
    private Integer did;
    private String dep_name;
    private String location;
    private List<Employee> employees;//一对多

    public DepartmentEmp() {
    }

    public DepartmentEmp(Integer did, String dep_name, String location, List<Employee> employees) {
        this.did = did;
        this.dep_name = dep_name;
        this.location = location;
        this.employees = employees;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "DepartmentEmp{" +
                "did=" + did +
                ", dep_name='" + dep_name + '\'' +
                ", location='" + location + '\'' +
                ", employees=" + employees +
                '}';
    }
}
