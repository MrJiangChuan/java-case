package com.jc.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("tool")
public class Tool {

    @Value("剪刀")
    private String name;

    public Tool() {
    }

    public Tool(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "name='" + name + '\'' +
                '}';
    }
}
