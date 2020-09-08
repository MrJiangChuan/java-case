package com.jc.email;

public class Lenovo implements Sale {

    @Override
    public String sale(double money) {
        return "花了"+money+"钱买了电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑");
    }
}
