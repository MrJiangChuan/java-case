package com.jc;

/**
 * 数据类型：基本数据类型（4类8种）、引用数据类型
 * 1.基本数据类型
 *    1.1布尔类型boolean（1字节）
 *    1.2字符类型char(2字节unicode编码0-65535)
 *    1.3整形
 *      1.3.1字节类型（byte）1字节 -128-127
 *      1.3.2短整型（short）2字节 -32768-32767
 *      1.3.3整型（int）4字节 -2^31-2^31-1 默认
 *      1.3.4长整型（long）8字节 -2^63-2^63-1
 *    1.4浮点型
 *      1.4.1float(4字节)
 *      1.4.2double（8字节）   默认
 *  2.引用数据类型
 *     2.1数组
 *     2.2类
 *     2.3接口
 *     2.4Lambda
 *  注意：标识符：数字、字母、下划线、$(不能以数字开头)
 */
public class 数据类型 {
    /**
     * 使用数据类型创建变量
     * 注意：变量必须先赋值，再使用
     * @param args
     */
    public static void main(String[] args) {

        //1.布尔类型
        boolean a = true;
        System.out.println(a);
        boolean b;
        b = false;
        System.out.println(b);

        //2.char类型
        char c = 'a';
        System.out.println(c);
        c = 66;
        System.out.println(c);
        int d = 98;
        c = (char) d;
        System.out.println(c);
        c = '中';
        System.out.println(c);

        //3.整型
        byte aa = 127;
        System.out.println(aa);
        short bb = -32768;
        System.out.println(bb);
        int cc = 12134242;
        System.out.println(cc);
        long dd = 343151515151513L;
        System.out.println(dd);

        //4.浮点
        float ee = 12.331F;
        System.out.println(ee);
        double ff = 3242.424242;
        System.out.println(ff);

        //5.数组
        int[] a1 = new int[10];
        for (int i = 0; i < a1.length; i++) {
            a1[i] = i;
        }
        for (int item:a1) {
            System.out.print(item+" ");
        }
        System.out.println("");
        double[] b1 = new double[]{1.3,3.33,42.242,44.55,11.342};
        for (int i = 0; i < b1.length; i++) {
            System.out.print(b1[i]+" ");
        }
        System.out.println("");
        //6.类
        User user = new User("小明",42);
        System.out.println(user);
        //7.接口
        Flyable flyme = new Flyable() {
            @Override
            public void fly() {
                System.out.println("我会飞");
            }
        };
        flyme.fly();
        //8.Lamda表达式
        new Thread(()->{for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread()+":"+i);
        }}).start();







    }
}
