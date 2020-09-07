package linkedList;

//单向环形链表解决约瑟夫问题
public class Joseph {
    public static void main(String[] args) {
        CircleSingleList circleSingleList = new CircleSingleList();
        circleSingleList.addNumber(25);
        circleSingleList.showList();
        circleSingleList.josephList(1,2,25);

    }

    //创建一个环形单向链表
    static class CircleSingleList{
        //创建一个节点
        private Node first ;
        public void addNumber(int number){
            //校验数据
            if(number<1){
                System.out.println("数据输入有问题！");
                return ;
            }
            //使用循环创建环形链表
            Node cur = null;
            for (int i = 1; i <=number ; i++) {
                Node node = new Node(i);
                if (i == 1){//构建第一个小孩
                    first = node;
                    first.setNext(first);
                    cur = first;
                }else{
                    cur.setNext(node);
                    node.setNext(first);
                    cur = node;
                }
            }
        }
        //遍历环形链表
        public void showList(){
            //判空
            if(first == null){
                System.out.println("没有数据");
                return ;
            }
            //有数据，first不能动
            Node cur = first;
            while(true){
                System.out.println("number:"+cur.getNo());
                if(cur.getNext() == first){
                    break;
                }
                cur = cur.getNext();
            }
        }
        //约瑟夫环的出队处理
        /**
         * 利用辅助指针helper，指向first的前一个节点
         * helper与first向后两指针联动m-1次
         * 移动完毕后first指针后移，将待出圈节点进行删除
         */
        /**
         *
         * @param startNo  从第几个数开始数
         * @param countNum 每多少个数出圈
         * @param numbers  一共有多少个数
         */
        public void josephList(int startNo,int countNum,int numbers){
            //数据校验
            if(first == null || startNo < 1 ||startNo>numbers){
                System.out.println("数据有误！");
                return ;
            }
            Node helper = first;
            //使helper移动到first的前一个
            while(true){
                if(helper.getNext() == first){//指针移动到尾部
                    break;
                }
                helper = helper.getNext();
            }
            //此时first已经移动待该出圈的位置节点上了
            while(true){
                //圈中只剩一个数据
                if(helper == first){
                    break;
                }
                //指针移动
                for(int j = 0 ;j<countNum-1;j++){
                    first = first.getNext();
                    helper = helper.getNext();
                }
                System.out.println("出圈的小孩是："+first.getNo());
                first = first.getNext();
                helper.setNext(first);
            }
            System.out.println("The lucky Boy is "+first.getNo());
        }
    }

    static class Node {

        private  int no;
        private Node next;

        public Node(int no) {
            this.no = no;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
