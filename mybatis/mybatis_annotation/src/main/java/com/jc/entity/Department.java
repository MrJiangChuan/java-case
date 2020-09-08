package com.jc.entity;

import java.io.Serializable;

public class Department implements Serializable {
    private Integer did;
    private String dep_name;
    private String location;

    public Department() {
    }

    public Department(Integer did, String dep_name, String location) {
        this.did = did;
        this.dep_name = dep_name;
        this.location = location;
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

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", dep_name='" + dep_name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
