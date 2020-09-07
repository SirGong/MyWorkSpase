package com.xzy.prototype;

public class Test {
    @org.junit.Test
    public  void test() throws CloneNotSupportedException {
        Address address = new Address("shanxi", "xian", "710600");
        //原型对象
        Student s1 = new Student("Tom", 28, address);
        //克隆对象
        Student s2 = (Student) s1.clone();

        System.out.println("s1="+s1+"\t"+"s2="+s2);
        System.out.println(s1.getName());
        System.out.println(s2.getName());
        System.out.println("***************************引用类型的复制");
        System.out.println(s1.getAddress());
        System.out.println(s2.getAddress());
    }
}
