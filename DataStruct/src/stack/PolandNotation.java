package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //先给出一个逆波兰表达式
        //为了方便，用空格将数字与符号隔开
//        String suffixExpression = "30 4 + 5 * 6 -";
//        List<String> rpnList = getListString(suffixExpression);
//        System.out.println(rpnList);
//        System.out.println("..........................");
//        int res = calculate(rpnList);
//        System.out.println("计算的结果是：" + res);

        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println(infixExpressionList);
        List<String> suffixExpressionList = paresSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的List："+suffixExpressionList);
        System.out.println(expression+"="+calculate(suffixExpressionList));

    }
    //中缀表达式转后缀表达式的思路分析

    /**
     * 思路：
     * 1)初始化两个栈:运算符栈s1和储存中间结果的栈s2 ;
     * 2)从左至右扫描中缀表达式;
     * 3)遇到操作数时，将其压s2;
     * 4)遇到运算符时，比较其与s1栈顶运算符的优先级:
     * 1.如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈;
     * 2.否则，若优先级比栈顶运算符的高，也将运算符压入s1;
     * 3.否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较;
     * 5)遇到括号时:
     * (1)如果是左括号“("，则直接压入s1
     * (2)如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2,直到遇到左括号为止，此时将这一对括号丢弃
     * 6)重复步骤2至5，直到表达式的最右边
     * 7)将s1中剩余的运算符依次弹出并压入s2
     * 8)依次弹出s2中的元素并输出，结果的逆脚为中缀表达式对应的后缀表达式
     */
    //1+（（2+3）*4）-5 =>123+4*+5-
    //1.先将String转成List，方便遍历
    public static List<String> toInfixExpressionList(String s) {
        //定义一个List，存放数据
        List<String> ls = new ArrayList<String>();
        int i = 0;//遍历s
        String str;//对多位数的遍历
        char c;    //每遍历到一个字符，就放入到c
        do {
            //若果ch是非数字，需要加入到ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add(c + "");
                i++;
            } else {
                //如果是一个数，需要考虑多位数
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }

                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }

    //2.将转换的ArrayList转成后缀表达式对应的ArrayList
    public static List<String> paresSuffixExpressionList(List<String> ls) {
        Stack<String> s1 = new Stack<>();//符号栈
        //Stack<String> s2 = new Stack<>();
        //用ArrayList代替s2这个栈，S2全程不pop，二姐还要逆序操作
        List<String> s2 = new ArrayList<String>();
        //遍历ls
        for (String item : ls) {
            //如果是一个数，加入S2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {//如果是（，则入S1栈
                s1.push(item);
            } else if (item.equals(")")) {
                //如果是（，则依次弹出s1栈顶的元素，直到遇见 ） ，将 ） 出栈
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//将左括号出栈，目的，消除小括号
            } else {
                //当item的优先级小于等于s1栈顶运算符的优先级，将s1栈顶的运算符弹出并压入到s2中，
                // 再次转到(4.1)与s1中新的栈顶运算符相比较;
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //还需要将item压入S1
                s1.push(item);
            }
        }
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;//因为存放到List中的，顺序返回就是正确的顺序
    }

    //将后缀表达式依次将数据和运算符存入ArrayList中
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String elem : split) {
            list.add(elem);
        }
        return list;
    }

    //完成对后缀表达式的计算
    public static int calculate(List<String> ls) {
        //创建一个栈存放数字
        Stack<String> stack = new Stack<>();
        //遍历后缀表达式
        for (String item : ls) {
            if (item.matches("\\d+")) {
                //入栈
                stack.push(item);
            } else {//pop出两个数，运算得到结果并入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误！！！");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

//编写类，返回运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //一个方法，返回对应的优先级的数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符！！");
                break;
        }
        return result;
    }

}
