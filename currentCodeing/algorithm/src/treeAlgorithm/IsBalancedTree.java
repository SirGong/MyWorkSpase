package treeAlgorithm;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 */
public class IsBalancedTree {
    public boolean IsBalanced_Solution(TreeNode root) {
        return treeDepth(root) != -1;
    }

    public static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        if (left == -1)//左子树不平衡，返回-1
            return -1;
        int right = treeDepth(root.right);
        if (right == -1)//右子树不平衡，也返回-1
            return -1;

        if ((left - right) > 1 || (left - right) < -1) //若不平衡，返回-1
            return -1;
        else
            return left > right ? left + 1 : right + 1;
    }
}
