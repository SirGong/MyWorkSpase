package stack;

/**
 * 使用数组模拟栈
 * top ：表示栈顶，初始化默认为-1
 * 入栈：top++ ，stack[top] = data
 * 出栈：val = stack[top --] ,return val
 */
public class ArrayStack {
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈
    private int top = -1;//栈底，初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        //判断栈满？
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        //判空？
        if (isEmpty()) {
            throw new RuntimeException("无数据！！");
        }
        int val = stack[top];
        top--;
        return val;
    }

    //遍历栈
    public void list() {
        //判空？
        if (isEmpty()) {
            System.out.println("无数据！！");
            return;
        }
        for (int i = top; i > -1; i--) {
            System.out.println("stack[" + i + "]=" + stack[i]);
        }
    }

    /*
     * 以下方法为扩展计算器功能需要
     */
    //返回运算符的优先级，优先级用数值表示，优先级越高，数值越大
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是否是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //进行数值计算
    public int cal(int val1, int val2, int oper) {
        int res = 0;//存放计算结果
        switch (oper) {
            case '+':
                res = val1 + val2;
                break;
            case '-':
                res = val2 - val1;//顺序
                break;
            case '*':
                res = val1 * val2;
                break;
            case '/':
                res = val2 / val1;//顺序
                break;
            default:
                break;
        }
        return res;
    }
    //返回当前栈顶的值，不是pop
    public int peek(){
        return stack[top];
    }
}
