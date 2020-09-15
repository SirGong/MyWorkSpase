package stackQueueAlgorithm;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */

public class IsPopOrder {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {4,3,5,1,2};
        boolean popOrder = isPopOrder(a, b);
        System.out.println(popOrder);
    }

    public static boolean isPopOrder(int[] pushA,int[] popA){
        //将数组A压栈，如果栈顶元素与数组B的元素相等，然后弹栈，B数组后移。
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (i<pushA.length){
            stack.push(pushA[i]);
            //栈顶元素与弹出序列的元素相等时
            if (stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
            i++;

        }
        //所有元素已经入栈，继续判断栈顶元素是否等于出栈序列的元素
        while (j<popA.length){
            if(stack.peek() == popA[j]){
                stack.pop();
            }
            j++;
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}
