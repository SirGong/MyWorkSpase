package treeAlgorithm;

import sun.reflect.generics.tree.Tree;

import javax.xml.transform.Source;
import java.security.PublicKey;
import java.util.Stack;

public class NoRecPreOrder {
    public static void print(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            System.out.printf("%5d", curr.val);
            stack.pop();
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }

    public static void print2(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            //沿着左子树一直入栈
            while (temp != null) {
                stack.push(temp);
                System.out.printf("%5d",temp.val);
                temp = temp.left;
            }
            //一层层向上循环右子树
            temp = stack.peek();
            stack.pop();
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
        print2(root);
    }
}
