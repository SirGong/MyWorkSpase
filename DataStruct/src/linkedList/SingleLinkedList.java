package linkedList;

import java.util.Stack;

public class SingleLinkedList {
    //提供各种本地方法,首先创建头结点
    private HeroNode head = new HeroNode(0,"","");
    //提供公开的方法返回单链表的头
    public HeroNode getHead() {
        return head;
    }

    //添加新的节点,不考虑编号的顺序
    public void add (HeroNode heroNode){
        HeroNode temp = head;//相当于辅助指针,指向头结点
        //退出while循环时，temp已经指向要添加的位置
        while(true){
            if(temp.next==null){//已经找到最后
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }
    //添加节点时按照数据的编号顺序添加
    public void addByIndex(HeroNode heroNode){
        HeroNode temp = head;//辅助变量
        boolean flag = false;//标识新节点的编号是否存在
        while (true){
            if(temp.next == null){ //已经到最后
                break;
            }
            if(temp.next.no>heroNode.no){//位置找到
                break;
            }else if (temp.next.no==heroNode.no){
                flag=true;//编号已经存在
                break;
            }
            temp = temp.next; //遍历链表
        }
        if (flag){
            System.out.println("编号存在，数据不能添加");
        }
        heroNode.next = temp.next;
        temp.next = heroNode;
    }
    //单链表的修改
    public void update(HeroNode newHeroNode){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空！！");
            return;
        }
        //借助辅助指变量，寻找节点的编号
        HeroNode temp = head.next;
        boolean flag = false;//标识是否找到需要修改的节点
        while(true){
            if(temp == null){//已经到链表的尾部
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到节点
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else{
            //没有找到节点
            System.out.println("没有找到节点信息！");
        }
    }
    //删除单链表的节点
    public void del(int number){
        HeroNode temp = head;
        boolean flag = false;//标识是否找到删除的节点
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == number){//找到待删除节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            //找到删除位置
            temp.next = temp.next.next;
        }else {
            System.out.println("未找到节点信息");
        }
    }
    //获取单链表节点的有效个数
    public static int  getLength(HeroNode head){
        if (head.next==null){//链表为空
            return 0;
        }
        int length = 0;
        HeroNode current = head.next;
        while (current != null){
            length++;
            current = current.next;//遍历节点，直到末尾
        }
        return length;
    }
    //查找单链表的倒数第K个节点
    public  HeroNode findLastIndexNode(HeroNode head,int index){
        //判空
        if(head.next==null){
            return  null;
        }
        //链表不为空，先得到链表的长度，再校验索引index
        int size = getLength(head);
        if(index <=0 || index > index){
            return null;
        }
        //定义辅助变量
        HeroNode cur = head.next;
        for(int i = 0;i<(size-index);i++){
            cur = cur.next;
        }
        return cur;
    }
    //将单链表进行反转
    public void  reverseList(HeroNode head){
        //利用头删头插进行反转
        //一个或零个节点无需反转
        if(head.next == null || head.next.next==null){
            return ;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        //创建一个辅助头结点
        HeroNode reverseHead = new HeroNode(0,"","");
        //遍历原来的链表，遍历之后去出放入新的节点
        while(cur!=null){
            next = cur.next;//保存带取出节点的下一个节点
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }
    //逆序打印单链表，反转不建议，会破坏链表原有结构
    //可以利用栈将链表顺序压入栈中，顺序弹栈
    public void rePrintList(HeroNode head){
        if(head.next==null){
            return ; //链表为空
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while(cur!=null){
            stack.push(cur);
            cur = cur.next;//cur后移，遍历链表
        }
        while(stack.size()>0){
            //顺序出栈，依次打印
            System.out.println(stack.pop());
        }
    }
    //合并两个有序链表，使之新链表依然有序
    public  HeroNode mergeLinkedList(HeroNode head1 , HeroNode head2){
        //两个链表都为空，结束方法
        if(head1.next == null){
            return head2;
        }
        if(head2.next==null){
            return head1;
        }
        //两条链表都不为空，进行比较合并
        HeroNode newHead = null;
        if(head1.no<=head2.no){
            newHead = head1;
            head1 = head1.next;
        }else {
            newHead = head2;
            head2 = head2.next;
        }
        HeroNode temp = newHead;

        while(head1 != null && head2 != null){
            if(head1.no <= head2.no){
                temp.next = head1;
                head1 = head1.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        //while循环结束之后，其中一个链表已经全部插入合并的新链表中
        if(head1 == null){
            temp.next = head2;
        }else {
            temp.next = head1;
        }
        return newHead;
    }

    //显示链表，遍历
    public void list(){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head.next;
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

    //构建单链表的节点数据
    class HeroNode{
        public  int no;
        public String name;
        public String nickName;
        public HeroNode next;
        //初始化构造器
        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }
        //重写toString方法
        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }
