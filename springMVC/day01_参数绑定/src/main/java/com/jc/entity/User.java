package com.jc.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class User implements Serializable {
    private String username;
    private Integer age;
    private Date birthday;
    private Integer[] num;
    private List<String> list;
    private Map<String,Integer> map;

    public User() {
    }

    public User(String username, Integer age, Date birthday, Integer[] num, List<String> list, Map<String, Integer> map) {
        this.username = username;
        this.age = age;
        this.birthday = birthday;
        this.num = num;
        this.list = list;
        this.map = map;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer[] getNum() {
        return num;
    }

    public void setNum(Integer[] num) {
        this.num = num;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", num=" + Arrays.toString(num) +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
