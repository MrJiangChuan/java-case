package com.jc;

/**
 * 方法的定义与使用
 *方法的定义与调用
 *
 * 方法名--输入（参数列表）---输出（返回值）
 *
 * 方法的重载(参数列表个数不同、类型不同、顺序不同)
 */
public class 方法 {

    public static void main(String[] args) {

        method_01();
        System.out.println(method_02());
        method_01(12,34);

    }

    private static int method_02() {
        return 12*22;
    }

    private static void method_01() {

        System.out.println("rrrrr");

    }

    private static void method_01(int a, int b) {
        System.out.println(a+b);
    }


}
