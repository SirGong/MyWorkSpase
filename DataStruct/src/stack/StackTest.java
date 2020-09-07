package stack;

import java.util.Scanner;

/**
 * @author ASUS
 * @Date 2020/5/29 17:00
 * @Version 1.0.0
 */
public class StackTest {
    public static void main(String[] args) {
        //测试栈,创建一个栈
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner in = new Scanner(System.in);
        while(loop){
            System.out.println("show:显示");
            System.out.println("exit:退出");
            System.out.println("pop: 出栈");
            System.out.println("push:入栈");
            System.out.println("请输入：");
            key = in.next();
            switch (key){
                case "show":
                    arrayStack.list();
                    break;
                case "pop":
                    try{
                        int res = arrayStack.pop();
                        System.out.println("出栈的数据是："+res);

                    }catch(Exception e){
                    System.out.println(e.getMessage());
                    }
                    break;
                case "push":
                    System.out.println("请输入入栈数据：");
                    int val = in.nextInt();
                    arrayStack.push(val);
                    break;
                case "exit":
                    in.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("EXIT！！");

    }
}
