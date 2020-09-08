package com.jc.entity;


import java.io.Serializable;

public class EmployeeDep implements Serializable {
    private Integer uid;
    private String name;
    private Integer age;
    private String sex;
    private Integer dep_id;
    private Department department;//一对一

    public EmployeeDep() {
    }

    public EmployeeDep(Integer uid, String name, Integer age, String sex, Integer dep_id, Department department) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.dep_id = dep_id;
        this.department = department;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getDep_id() {
        return dep_id;
    }

    public void setDep_id(Integer dep_id) {
        this.dep_id = dep_id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", dep_id=" + dep_id +
                ", department=" + department +
                '}';
    }
}
