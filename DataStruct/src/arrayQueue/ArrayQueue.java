package arrayQueue;
/*
* 该队列的数组只能使用一次，使用一次就无法使用，尚未优化，需要利用算法改进常环形队列
* 优化思路：front指向队头元素，及arr[front]为队头；
* rear指向队尾元素的后一个位置，同时希望空出一个位置
*队满条件：(rear+1)%maxSize = front 队满
* 队空条件：rear == front 队空
* 队列中的有效数据个数：(rear+maxSize-front)%maxSize
*/


public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int arr[];//用于存放数据，用数组模拟队列

    //初始化队列
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }
    //判断队列是否满
    public boolean isFull(){
        return  rear == maxSize-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }
    public void addQueue(int n){
        //先判断队列是否满
        if (isFull()){
            System.out.println("队列已满，无法添加数据！");
            return;
        }
        rear++;
        arr[rear] = n;
    }
    //队头数据出队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法操作！");
        }
        return arr[++front];
    }
    //显示所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，无法操作！");
            return ;
        }
        for (int i = front+1; i <arr.length ; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //显示队头数据，并不出队
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法操作！");
        }
        return arr[front+1];
    }
}
