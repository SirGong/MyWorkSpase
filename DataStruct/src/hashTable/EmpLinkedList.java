package hashTable;


public class EmpLinkedList {
    //头指针，指向第一个雇员，有效
    private Emp head;

    //添加,直接添加到链表最后，id自增长
    public void add(Emp emp) {
        //添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个
        Emp cur = head;
        while (true) {
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        cur.next = emp;
    }

    //遍历,no为哈希表链表的编号
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no + 1) + "条链表为空");
            return;
        }
        System.out.print("第" + (no + 1) + "条链表为: ");
        Emp cur = head;
        while (true) {
            System.out.printf("=> id = %d  name = %s\t", cur.id, cur.name);
            if (cur.next == null) {
                break;
            }
            cur = cur.next;//遍历
        }
        System.out.println();
    }

    //根据id查找
    public Emp finById(int id) {
        if (head == null) {
            System.out.println("链表为空");
        }
        Emp curEmp = head;//辅助指针
        while (true) {
            if (curEmp.id == id) {//找到
                break;
            }
            if (curEmp.next == null) {//没找到,要结束
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}
