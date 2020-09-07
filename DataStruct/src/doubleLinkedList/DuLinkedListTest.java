package doubleLinkedList;


/**
 * @author ASUS
 * @Date 2020/5/28 11:53
 * @Version 1.0.0
 */
public class DuLinkedListTest {
    public static void main(String[] args) {

        Node hero1 = new Node(1,"宋江","及时雨");
        Node hero2 = new Node(2,"卢俊义","玉麒麟");
        Node hero3 = new Node(3,"吴用","智多星");
        Node hero4 = new Node(4,"林冲","豹子头");
        Node hero5 = new Node(5,"hhh","sss");
        Node hero6 = new Node(6,"吴用","智多星");
        Node hero7 = new Node(7,"林冲","豹子头");
        Node hero8 = new Node(8,"hhh","sss");

        DuLinkedList duLinkedList = new DuLinkedList();

        duLinkedList.add(hero1);
        duLinkedList.add(hero2);
        duLinkedList.add(hero3);
        duLinkedList.add(hero4);

//        duLinkedList.del(2);

        duLinkedList.list();

//        Node newHero = new Node(4, "ddd", "ssa");
//        duLinkedList.update(newHero);


    }
}
