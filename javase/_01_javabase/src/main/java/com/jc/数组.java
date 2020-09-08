package com.jc;

/**
 * 数组中存的数据类型相同，长度固定
 */
public class 数组 {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,5,6};
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        double[] b = new double[10];
        for (double bb:b) {
            System.out.println(bb);
        }

        String[] c = {"qe","gf","re","cx","ds"};
        for (String cc:c) {
            System.out.println(cc);
        }
    }

}
