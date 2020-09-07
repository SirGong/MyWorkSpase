package stack;

import java.util.Stack;

/**
 * @author ASUS
 * @Date 2020/5/29 17:16
 * @Version 1.0.0
 */
//使用单链表实现栈
public class LinkedListStack {
    Node first = new Node(-1);
    Node top = first;

    //栈空
    public boolean isEmpty() {
        return first.getNext() == null;
    }

    //入栈
    public void push(int value) {
        Node newNode = new Node(value);
        top.setNext(newNode);
        top = top.getNext();
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("无数据！！");
        }
        Node cur = first;
        //循环跳出，cur位于top之前
        while (true) {
            if (cur.getNext() == top) {
                break;
            }
            cur = cur.getNext();
        }
        int value = top.getVal();
        cur.setNext(null);
        top = cur;
        return value;
    }

    //遍历栈
    public void list() {
        //判空？
        if (isEmpty()) {
            System.out.println("无数据！！");
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = first.getNext();
        while (cur != null) {
            stack.push(cur);
            cur = cur.getNext();//cur后移，遍历链表
        }
        while (stack.size() > 0) {
            //顺序出栈，依次打印
            System.out.println(stack.pop());
        }
    }
}

class Node {
    //存放数值
    private int val;
    private Node next;

    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
