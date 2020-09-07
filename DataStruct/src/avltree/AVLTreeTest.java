package avltree;


public class AVLTreeTest {
    public static void main(String[] args) {
        //int [] arr = {4,3,6,5,7,8};
        int [] arr = {10,12,8,9,7,6};

        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历：");
        avlTree.infixOrder();
        System.out.println("树的高度："+avlTree.getRoot().height());
        System.out.println("左子树的高度："+avlTree.getRoot().leftHeight());
        System.out.println("右子树的高度："+avlTree.getRoot().rightHeight());
    }
}
