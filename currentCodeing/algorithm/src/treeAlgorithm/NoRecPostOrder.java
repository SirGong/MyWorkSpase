package treeAlgorithm;

import java.util.Stack;

public class NoRecPostOrder {
    public static void print(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        //用来标记访问的是左孩子还是右孩子
        TreeNode last = root;
        stack.push(p);
        while (!stack.isEmpty()) {
            p = stack.peek();
            if ((p.left == null && p.right == null) || (p.right == null && last == p.left) || last == p.right) {
                System.out.printf("%5d", p.val);
                last = p;
                stack.pop();
            } else {
                if (p.right != null)
                    stack.push(p.right);
                if (p.left != null)
                    stack.push(p.left);
            }
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
    }
}
