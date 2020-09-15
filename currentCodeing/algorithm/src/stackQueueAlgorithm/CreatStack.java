package stackQueueAlgorithm;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class CreatStack {
    private static Stack<Integer> stack = new Stack<>();
    private static Integer minValue = Integer.MIN_VALUE;

    public void push(int node) {
        if (stack.isEmpty()) {
            minValue = node;
        } else {
            if (node <= minValue) {
                stack.push(minValue);
                minValue = node;
            }
            stack.push(node);
        }
    }

    public void pop() {
        if (stack.size() == 0) return;
        if (minValue == stack.peek()) {
            if (stack.size() > 1) {
                stack.pop();
                minValue = stack.peek();
            } else {
                minValue = Integer.MAX_VALUE;
            }
        }
        stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minValue;
    }
}
