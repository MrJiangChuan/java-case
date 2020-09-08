package com.jc;

public class _01_类的定义 {
    public static void main(String[] args) {

        Student student = new Student("dd",22,true);
        System.out.println(student.toString());
        student.eat();
    }
}


/**
 * 模拟一个学生
 */
class Student{
    private String name;
    private int age;
    private boolean male;

    public Student() {
    }

    public Student(String name, int age, boolean male) {
        this.name = name;
        this.age = age;
        this.male = male;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", male=" + male +
                '}';
    }

    public void eat(){
        System.out.println("吃饭");
    }
}
