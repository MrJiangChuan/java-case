package com.jc;

import java.util.Arrays;

/**
 * 面向过程：当需要实现一个功能时，每一个步骤都需要亲力亲为
 * 面向对象:当需要实现一个功能时，不关心具体步骤，找一个已经具有该功能的人，帮我做事
 */
public class 面向对象与面向过程比较 {

    public static void main(String[] args) {
        //1.面向过程：打印输出[10,20,30,40,50,60]
        int[] array = {10,20,30,40,50,60};
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if(i == array.length - 1){
                System.out.print(array[i]+"]");
            }else {
                System.out.print(array[i]+",");
            }
        }

        System.out.println();
        //2.面向对象，调用Arrays工具类
        System.out.println(Arrays.toString(array));
    }


}
