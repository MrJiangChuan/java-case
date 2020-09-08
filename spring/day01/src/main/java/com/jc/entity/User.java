package com.jc.entity;

import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.*;

public class User implements Serializable {
    private Integer id;
    private String name;
    private Date birthday;
    private String[] str;
    private List<Integer> list;
    private Set<Role> sets;
    private Map<String,String> map;

    public User() {
    }

    public User(Integer id, String name, Date birthday, String[] str, List<Integer> list, Set<Role> sets, Map<String, String> map) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.str = str;
        this.list = list;
        this.sets = sets;
        this.map = map;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String[] getStr() {
        return str;
    }

    public void setStr(String[] str) {
        this.str = str;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public Set<Role> getSets() {
        return sets;
    }

    public void setSets(Set<Role> sets) {
        this.sets = sets;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", str=" + Arrays.toString(str) +
                ", list=" + list +
                ", sets=" + sets +
                ", map=" + map +
                '}';

    }
}
