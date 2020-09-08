package com.jc;

/**
 * 数据类型转换规则
 * 1.自动转换 （数据类型从小到大） 隐式
 * 2.强制转换  （数据类型从大到小） 显式
 *
 * 注意：byte/short/char在发生数学运算时，都会被提升为int类型，然后再计算（
 * 纯数字相运算，只要不超过范围，无需转换，编译器的常量优化）
 *       boolean不能发生数据类型转换
 * '0'--48
 * 'A'--65
 * 'a'--97
 */
public class 数据类型转换 {
    public static void main(String[] args) {

        //1.自动转换
        int a = 1313333;
        long b = 31313131141414141L;
        System.out.println(a);
        System.out.println(b);
        b = a;//自动转换
        System.out.println(b);

        float a1 = 12.33F;
        double b1 = 13.313131;
        b1 = a1;
        System.out.println(b1);

        //2.强制转换
        int aa = (int) 221133333333L;//数据溢出，数截断
        System.out.println(aa);

        float a2 = 12.33F;
        double b2 = 13.313131;
        a2 = (float) b2;//精度损失
        System.out.println(a2);

        int cc = (int) 23.44;
        System.out.println(cc);

        char dd = 'B';
        char ss = (char) (dd + 2);
        System.out.println(dd+1);
        System.out.println((char)(dd+3));
        System.out.println(ss);

        byte a3 = 33;
        byte a4 = 34;
        byte c2 = (byte) (a3 + a4);
        System.out.println(c2);

        byte d2 = 33 + 33;//纯数字相加没问题
        System.out.println(d2);

        float aaa =22.33F, bbb = 33.33F;
        float d3 = (float) (aaa+bbb+3.44);
        System.out.println(d3);


//        boolean f1 = true;
//        int f2 = f1 + 33; //boolean不能进行数据类型转换
//        System.out.println(f2);

        char aaaa = 21100;
        System.out.println(aaaa);

        int bbbb = '亲';
        System.out.println(bbbb);

        byte sd = 2131313 - 2131200;
        System.out.println(sd);









    }

}
