package com.jc;

import java.util.ArrayList;

public class _03_ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(12);
        arrayList.add(23);
        arrayList.add(22);
        for (Integer a:arrayList) {
            System.out.println(a);
        }
    }
}
