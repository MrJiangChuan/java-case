package com.jc;

import java.io.File;
import java.io.FileInputStream;

/**
 * 1.顺序结构
 * 2.选择结构
 * 3.循环结构(break,continue)
 */
public class 流程控制 {
    public static void main(String[] args) {

        //1.顺序结构
        System.out.println("今天天气不错");
        System.out.println("我们出去玩吧");
        System.out.println("可以啊");

        //2.选择结构
        //2.1单if语句
        if (1 < 3) {
            System.out.println(333);
        }
        //2.2if ... else
        if (2 > 3) {
            System.out.println(444);
        } else {
            System.out.println(555);
        }
        //2.3if--else if...else
        int ss = 8;
        if (ss < 5) {
            System.out.println(ss);
        } else if (ss >= 5 && ss < 10) {
            System.out.println(ss);
        } else {
            System.out.println(ss);
        }
        //2.4switch
        //注意检测量只能是：char/byte/short/int String enum枚举
        char ff = 'q';
        switch (ff) {
            case 'q':
                System.out.println('q');
                break;
            case 'a':
                System.out.println('a');
                break;
            default:
                System.out.println('g');
                break;
        }

        //3.循环结构
        for (int i = 0; i < 10; i++) {
            System.out.print(i);

        }
        System.out.println("------------");
        int j = 0;
        while (j < 10) {
            System.out.println(j);
            j++;
        }
        int k = 0;
        System.out.println("------------");
        do {
            System.out.println(k);
            k++;
        } while (k < 10);

    }


}
