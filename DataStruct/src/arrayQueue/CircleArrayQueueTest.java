package arrayQueue;

import java.util.Scanner;

public class CircleArrayQueueTest {
    public static void main(String[] args) {
        //初始化队列,约定有一个空位置，所以实际长度为3
        CircleArrayQueue queue = new CircleArrayQueue(4);
        //输出一个菜单，用于用户选择
        char key = ' '; //接受用户输入
        Scanner in = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):获取队头，出队列");
            System.out.println("h(head):显示队头");
            System.out.println("e(exit):退出");
            key = in.next().charAt(0);//接收输入字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入要入队的数据：");
                    int value = in.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g'://可能有异常抛出
                    try {
                        int res = queue.getQueue();
                        System.out.println("取出的队头数据是:" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = queue.headQueue();
                        System.out.println("队头数据是:" + head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    in.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("exit!!!");

    }
}
