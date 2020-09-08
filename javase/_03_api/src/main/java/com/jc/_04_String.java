package com.jc;

import java.util.Arrays;

public class _04_String {

    public static void main(String[] args) {
        String a = "3dad",b = "3DAD";
        System.out.println(a.equals(b));
        System.out.println(a.equalsIgnoreCase(b));

        String ss = "adsfde2rffs";
        char[] chars = ss.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]+" ");
        }
        System.out.println();
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]+" ");
        }
    }


}
