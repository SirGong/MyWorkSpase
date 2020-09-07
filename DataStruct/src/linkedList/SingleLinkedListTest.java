package linkedList;

/**
 * @author ASUS
 * @Date 2020/5/26 21:41
 * @Version 1.0.0
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
        HeroNode hero5 = new HeroNode(5,"hhh","sss");
        HeroNode hero6 = new HeroNode(6,"吴用","智多星");
        HeroNode hero7 = new HeroNode(7,"林冲","豹子头");
        HeroNode hero8 = new HeroNode(8,"hhh","sss");
        //创建一个链表
         SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
//         singleLinkedList.add(hero1);
//         singleLinkedList.add(hero4);
//         singleLinkedList.add(hero3);
//         singleLinkedList.add(hero2);

         singleLinkedList.addByIndex(hero1);
         singleLinkedList.addByIndex(hero5);
         singleLinkedList.addByIndex(hero3);
         singleLinkedList.addByIndex(hero7);

         singleLinkedList2.add(hero2);
        singleLinkedList2.add(hero4);
        singleLinkedList2.add(hero6);
        singleLinkedList2.add(hero8);



//         singleLinkedList.update(hero5);

//        singleLinkedList.del(4);
//        singleLinkedList.del(2);
//        singleLinkedList.del(3);
        System.out.println("链表1：");
         singleLinkedList.list();
        System.out.println("链表2：");
         singleLinkedList2.list();

//         System.out.println(singleLinkedList.getLength(singleLinkedList.getHead()));
//
//        HeroNode res = singleLinkedList.findLastIndexNode(singleLinkedList.getHead(),2);
//        System.out.println("倒数第二个节点为："+res.toString());

        //反转链表
//        singleLinkedList.reverseList(singleLinkedList.getHead());
//        System.out.println("反转后的链表为：");
//        singleLinkedList.list();

//        System.out.println("逆序打印的链表为：");
//        //不改变链表的结构
//        singleLinkedList.rePrintList(singleLinkedList.getHead());

//        System.out.println("合并后的链表为：");
//        HeroNode res = singleLinkedList.mergeLinkedList(singleLinkedList.getHead(),singleLinkedList2.getHead());
//        System.out.println(res.toString());
    }
}
