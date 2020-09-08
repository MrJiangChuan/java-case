package com.jc;

/**
 * Hello world!
 *
 */
@MyAnno(classname = "com.jc.long",methodname = "show")
public class App {
    public static void main( String[] args ) {
        MyAnno annotation = App.class.getAnnotation(MyAnno.class);
        String classname = annotation.classname();
        String methodname = annotation.methodname();
        System.out.println(classname);
        System.out.println(methodname);
    }
}
