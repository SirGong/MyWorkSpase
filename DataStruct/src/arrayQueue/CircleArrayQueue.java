package arrayQueue;

public class CircleArrayQueue {
    private int maxSize;
    private int front;
    //front指向队头元素，及arr[front]为队头；初始值为0
    private int rear;
    // rear指向队尾元素的后一个位置，同时希望空出一个位置，初始值为0
    private int arr[];//用于存放数据，用数组模拟队列
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }
    //添加数据到队列
    public void addQueue(int n){
        //先判断队列是否满
        if (isFull()){
            System.out.println("队列已满，无法添加数据！");
            return;
        }
        arr[rear] = n;
        rear = (rear+1)%maxSize;
    }
    //队头数据出队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法操作！");
        }
        //将队头元素保存到临时变量
        int value = arr[front];
        //将front后移，需要取模
        front  = (front + 1)%maxSize;
       return  value;
    }
    //显示队列所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，无法操作！");
            return ;
        }
        for (int i = front; i <front+size() ; i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }
    //求出当前队列中的有效数据的个数
    public  int size(){
        return (rear + maxSize - front )%maxSize;
    }
    //显示队头数据，并不出队
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法操作！");
        }
        return arr[front];
    }


}
