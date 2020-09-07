package com.xzy.test.clone;

import org.junit.Test;

public class Student implements Cloneable{

    private String name;
    private int age;


    public Student() {
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Test
    public void test() throws CloneNotSupportedException {
        Student s1 = new Student();
        s1.setName("张三");
        s1.setAge(18);
        Student s2 = (Student) s1.clone();

        s2.setName("student2");

        System.out.println(s1);
        System.out.println(s2);

        //地址已经不同
        System.out.println(s1==s2);

    }
}
