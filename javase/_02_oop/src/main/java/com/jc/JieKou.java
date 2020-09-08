package com.jc;

/**
 * 1.常量：public static final
 * 2.抽象方法：public abstract
 * 3.默认方法：public default  (jdk8)
 * 4.静态方法：public static   (jdk8)
 * 5.私有方法：private         (jdk9)
 */
public interface JieKou {
    int a = 12;
    void eat();
    default void sleep(){
        System.out.println("接口默认方法sleep");
    }
    static void study(){
        System.out.println("接口静态方法study");
    }
}
