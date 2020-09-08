package com.jc.email;

public class DemoTest1 {
    public static void main(String[] args) {
        Object obj = null;
        String str = (String) obj;
        System.out.println(str.equalsIgnoreCase("sad"));
        if(str == null) {
            System.out.println(11);
        }else {
            System.out.println(222);
        }
    }
}
