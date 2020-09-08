package com.jc;

public class 接口 {
    public static void main(String[] args) {

        System.out.println(JieKou.a);
        JieKou.study();

        JiekouImpl jiekou = new JiekouImpl();
        jiekou.eat();
        jiekou.sleep();

        JieKou jieKou2 = new JiekouImpl();
        jieKou2.eat();
        jieKou2.sleep();

    }
}

