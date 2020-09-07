package com.xzy.test;

import com.xzy.reflect.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Stack;

public class ReflectTest {
    @org.junit.Test
    public void test2() throws ClassNotFoundException {
        Class clazz = Class.forName("com.xzy.reflect.Person");
        //获取Person类的所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();

        System.out.println("获取到的所有方法：");
        for (Method methods : declaredMethods) {
            System.out.println(methods.toString());
        }

        //获取Person类的所有成员属性
        System.out.println("获取到的所有属性：");
        Field[] field = clazz.getDeclaredFields();
        for (Field f : field) {
            System.out.println(f.toString());
        }

        //获取 Person 类的所有构造方法信息
        Constructor[] constructor = clazz.getDeclaredConstructors();
        System.out.println("获取到的所有构造器：");
        for (Constructor c : constructor) {
            System.out.println(c.toString());
        }
    }

    @org.junit.Test
    public void test3() throws Exception {
        //获取 Person 类的 Class 对象
        Class clazz = Class.forName("com.xzy.reflect.Person");
        //使用.newInstance 方法创建对象
        Person p = (Person) clazz.newInstance();
        //获取构造方法并创建对象
        Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
        //创建对象并设置属性
        Person p1 = (Person) c.newInstance("张三", 20);
        System.out.println(p);
        System.out.println(p1);

    }

    @org.junit.Test
    public void test4() throws Exception {
        //获取 Person 类的 Class 对象
        Class clazz = Class.forName("com.xzy.reflect.Person");

        //使用.newInstance 方法创建对象
        Person p = (Person) clazz.newInstance();

        //如果有参数可以在名字后面指定哪些参数的类型
        Method eat = clazz.getDeclaredMethod("eat");
        Method dance = clazz.getDeclaredMethod("dance");

        //重点：此处打开私有方法的访问权限，否则会报错
        dance.setAccessible(true);

        eat.invoke(p);
        dance.invoke(p);

    }
    @org.junit.Test
    public void test5(){
        String str = "student. a am I";
        StringBuilder stringBuilder = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] split = str.split(" ");
        for (String s : split) {
            stack.push(s);
        }
        while(!stack.empty()){
            stringBuilder.append(stack.pop()+" ");
        }
        String res = stringBuilder.toString();
        String result = res.substring(0,res.length()-1);
        System.out.println(result);

    }
}
