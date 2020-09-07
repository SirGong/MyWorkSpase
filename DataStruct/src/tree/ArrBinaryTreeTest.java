package tree;

/**
 * @author ASUS
 * @Date 2020/6/6 17:54
 * @Version 1.0.0
 */
public class ArrBinaryTreeTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.perOrder();//1,2,4,5,3,6,7
    }
}

class ArrBinaryTree {
    /*
        顺序存储二叉树：
        第n个节点的左子节点为2*n+1
        第n个节点的右子节点为2*n+2
        第n个节点的父节点为：(n-1)/2
        n:从0开始
     */
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重载先序遍历
    public void perOrder() {
        this.preOrder(0);
    }

    //编写一个方法，对于顺序存储的二叉树进行先序遍历
    //index 数组的下标
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组不存在或者为空~~");
        }
        //输出当前元素
        System.out.print(arr[index] + "\t");
        //向左子树递归
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        //向右子树递归
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }
}
