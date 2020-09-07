package hashTable;


import java.util.Scanner;

public class HashTableTest {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        //菜单
        String key = "";
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加");
            System.out.println("list：显示");
            System.out.println("find： 查找");
            System.out.println("exit：退出");
            key = in.next();
            switch (key) {
                case "add":
                    System.out.println("输入id：");
                    int id = in.nextInt();
                    System.out.println("输入name：");
                    String name = in.next();
                    //创建员工
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    int no = in.nextInt();
                    hashTab.findById(no);
                    break;
                case "exit":
                    in.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
