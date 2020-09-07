package doubleLinkedList;

//双向链表
public class DuLinkedList {
    //初始化双向链表
    private Node head = new Node(0,"","");

    public Node getHead(){
        return head;
    }
    //向双向链表的尾部添加
    //添加新的节点,不考虑编号的顺序
    public void add (Node node){
        Node temp = head;//相当于辅助指针,指向头结点
        //退出while循环时，temp已经指向要添加的位置
        while(true){
            if(temp.next==null){//已经找到最后
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }
    //修改双向链表的数据
    public void update(Node newNode) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空！！");
            return;
        }
        //借助辅助指变量，寻找节点的编号
        Node temp = head.next;
        boolean flag = false;//标识是否找到需要修改的节点
        while (true) {
            if (temp == null) {//已经到链表的尾部
                break;
            }
            if (temp.no == newNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到节点
        if(flag){
            temp.name = newNode.name;
            temp.nickName = newNode.nickName;
        }else{
            //没有找到节点
            System.out.println("没有找到节点信息！");
        }
    }
    //删除双向链表的节点，对于双向链表何以直接找到待删节点，找到后自我删除
    public void del(int number){
        if(head.next==null){
            System.out.println("链表为空！");
            return ;
        }
        Node temp = head.next;
        boolean flag = false; //标识是否找到删除的节点
        while(true){
            if(temp == null){ //已经找到最后，未找到
                break;
            }
            if(temp.no == number){//找到待删除节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            //已经找到，删除节点
            temp.pre.next = temp.next;
            //如果是最后一个节点，不需要执行下面这句话
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("未找到节点信息");
        }
    }
    //遍历双向链表
    public void list(){
        //判断链表是否为空
        if(head==null){
            System.out.println("链表为空！");
            return;
        }
        Node temp = head.next;
        while(true){
            if(temp == null){//已经到节点的最后
                break;
            }
            //输出节点信息
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

}
class Node {
    public   int no;
    public String name;
    public String nickName;
    public Node pre;
    public Node next;

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
