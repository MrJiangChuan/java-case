package com.jc;

/**
 * 1.算术运算符
 * + - * / % ++ --
 * 2.关系运算符
 * > >= < <= == !=
 * 3.逻辑运算符（短路）
 * && || !
 * 4.赋值运算符(隐藏了类型强制转换)
 * += -= *= /= %=
 * 5.条件运算符
 * ? :
 * 6.位逻辑运算符
 * >> << & | ^
 */
public class 运算符 {

    public static void main(String[] args) {

        //1.算术运算符
        System.out.println(30+2434);
        System.out.println(30-324);
        System.out.println(30*88);
        System.out.println(20/3);
        System.out.println(20.0/3);
        System.out.println(30%21);
        System.out.println(20.0%3);
        int i=0;
        System.out.println(i++);
        System.out.println(++i);

        //2.关系运算符
        System.out.println(1>2);
        System.out.println(12>=3);
        System.out.println(1<3);
        System.out.println(1<=3);
        System.out.println(2==2);
        System.out.println(2!=3);

        //3.逻辑运算的
        System.out.println(2>3&&2<33);
        System.out.println(12>3||33<33);
        System.out.println(!(2>=3));

        //4.赋值运算符
        int ds = 10;
        ds+=12;
        System.out.println(ds);

        //5.条件运算符
        System.out.println(3>2?3:4);
//        int dfc = 1>3?3.4:4;//错误写法

        //6.位运算符
        System.out.println(2&3);//2
        System.out.println(2|3);//3
        System.out.println(2^3);//1
        System.out.println(2>>1);//1
        System.out.println(2<<1);//4









    }


}
