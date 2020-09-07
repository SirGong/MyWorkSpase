package hashTable;

//哈希表，管理多条链表
public class HashTab {
    EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTab(int size) {
        this.size = size;
        //初始化链表
        empLinkedListArray = new EmpLinkedList[size];
        //分别初始化每一条链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加员工
    public void add(Emp emp) {
        //根据员工的id得到应该添加到那条链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp添加到对应链表
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //遍历所有链表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //查找（根据输入的id）
    public void findById(int id) {
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].finById(id);
        if (emp != null) {
            System.out.printf("在第%d条链表中找到该数据！ id = %d", (empLinkedListNo + 1), id);
        } else {
            System.out.println("没有相关数据");
        }
    }

    //散列函数，使用取模法
    public int hashFun(int id) {
        return id % size;
    }
}
