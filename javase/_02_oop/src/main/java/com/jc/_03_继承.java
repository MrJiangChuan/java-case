package com.jc;

import java.lang.reflect.Field;

public class _03_继承 {
    public static void main(String[] args) throws ClassNotFoundException {
        Work work = new Work();

    }
}

//定义父类
class Employee{

    static {
        System.out.println("父类静态构造代码块");
    }

    public Employee(){
        System.out.println("父类构造方法");
    }

}

//定义子类
class Work extends Employee {

    static {
        System.out.println("子类静态构造代码块");
    }

    public Work(){
        System.out.println("子类构造方法");
    }
}
