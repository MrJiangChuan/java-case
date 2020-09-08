package com.jc;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _01_File {
    public static void main(String[] args) throws IOException {

//        method_01();
//        method_02();
//        method_03();
//        method_04();
//        method_05(new File("C:\\Users\\10735\\Desktop"));
        PrintStream pt = new PrintStream("a.txt");
        pt.println(123);
        pt.println("dsfsf");
        pt.println(true);
    }

    /**
     * 递归文件
     * @param file
     */
    private static void method_05(File file) {
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().endsWith(".pdf");
            }
        });
        for (File file1 : files) {
            if(file1.isDirectory()){
                method_05(file1);
            }else {
                System.out.println(file1);
            }
        }
    }

    private static void method_04() {
        File f1 = new File("C:\\Users\\10735\\Desktop");
//        File[] files = f1.listFiles();
        File[] files = f1.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().endsWith(".pdf");
            }
        });
        for (File file : files) {
            if(file.isDirectory()){
                method_04();
            }else {
                System.out.println(file);
            }
        }
    }

    private static void method_03() throws IOException {
        File f1 = new File("C:\\Users\\10735\\Desktop");
        String[] list = f1.list();
        System.out.println(Arrays.toString(list));
        File f2 = new File(f1,"aa/a.txt");
        boolean newFile = f2.createNewFile();
        System.out.println(newFile);


    }

    private static void method_02() {
        File f1 = new File("C:\\Users\\10735\\Desktop\\c3p0-config.xml");
        System.out.println(f1.getAbsoluteFile());
        System.out.println(f1.getPath());
        System.out.println(f1.getName());
        System.out.println(f1.length());
        System.out.println(f1.exists());
    }


    private static void method_01() {
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);

    }
}
