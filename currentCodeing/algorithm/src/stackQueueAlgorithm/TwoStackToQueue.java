package stackQueueAlgorithm;

import java.util.Stack;

public class TwoStackToQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void  push(Integer node){
        //stack1作为辅助栈进行入队操作
        //stack2作为主栈用来保存已经入队的数据
        if(stack2.isEmpty()){
            stack2.push(node);
        }else{
            //stack2不为空，就将所有的数据依次弹出压入stack1
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            stack2.push(node);
            //将stack1的数据全部压回来
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

    }

    public int pop(){
       //出栈弹出stack2栈顶的数据即可
        return stack2.pop();
    }

}
