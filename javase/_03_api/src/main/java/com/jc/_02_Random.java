package com.jc;

import java.util.Random;

public class _02_Random {

    public static void main(String[] args) {

        Random rd = new Random();
        int num = 0;
        for (int i = 0; i < 10; i++) {
            num = rd.nextInt(10)+1;
            System.out.print(num+" ");
        }

    }
}
