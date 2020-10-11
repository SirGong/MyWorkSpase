package treeAlgorithm;

import java.util.Stack;

public class NoRecMidOrder {
    //二叉树的非递归中序遍历
    public static void print(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            //只要有左孩子，就将左孩子压入栈中
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.peek();
            stack.pop();
            System.out.printf("%5d", temp.val);
            temp = temp.right;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        print(root);
        System.out.println();
    }
}
