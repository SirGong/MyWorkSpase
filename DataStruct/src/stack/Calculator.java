package stack;

/**
 * @author ASUS
 * @Date 2020/5/29 19:22
 * @Version 1.0.0
 */

public class Calculator {
    public static void main(String[] args) {
        //输入表达式
        String expression = "20+10*10-20";
        //创建两个栈
        ArrayStack numberStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        //定义相关变量用于扫描
        String keepNumber = "";//用于处理多位数
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//用于将扫描到的字符存入ch
        //开始循环扫描表达式
        while (true) {
            //扫描字符串
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {
                //如果不为空，与栈顶符号进行比较
                if (!operStack.isEmpty()) {
                    //当前符号的优先级小于栈中符号的优先级
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        oper = operStack.pop();
                        res = numberStack.cal(num1, num2, oper);
                        //运算结果入栈
                        numberStack.push(res);
                        //操作符入栈
                        operStack.push(ch);
                    } else {
                        //优先级大于栈中符号，直接入栈
                        operStack.push(ch);
                    }
                } else {//判断该当前符号栈是否为空，为空直接入栈
                    operStack.push(ch);
                }
            } else {
                //numberStack.push(ch - 48);//字符1的值为49
                //处理多位数时，不能只入栈一部分
                //处理数时，需要向index后再看一位，如果是数，继续扫描，如果是符号，直接入栈
                //定义一个字符串变量用于拼接
                //如果ch已经是最后一位数据，直接入栈
                keepNumber += ch;
                if (index == expression.length() - 1) {
                    numberStack.push(Integer.parseInt(keepNumber));
                }
                //判断下一个字符是不是数字，是操作符则入栈，否则继续拼接
                else {
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numberStack.push(Integer.parseInt(keepNumber));
                        keepNumber = "";//清空上一次存储的数据
                    }
                }
            }
            //让index+1，是否扫描完毕
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //当表达式扫描完毕之后，顺序从栈中pop出数据进行计算
        while (true) {
            //符号栈为空，数栈中只有一个数即结果
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            oper = operStack.pop();
            res = numberStack.cal(num1, num2, oper);
            //运算结果入栈
            numberStack.push(res);
        }
        System.out.println("表达式" + expression + "=" + numberStack.pop());
    }
}