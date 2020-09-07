package com.xzy.prototype;

public class Student implements Cloneable{//实现cloneable接口，重写他的clone方法
    private String name;
    private  int age;
    private Address address;

    public Student(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    //浅复制所需重写的方法
/*    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/
    //深复制需要对引用类型的数据进行级联处理
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student s = (Student) super.clone();
        s.setAddress((Address) address.clone());
        return s;
    }
}
