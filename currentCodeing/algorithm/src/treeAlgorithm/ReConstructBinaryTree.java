package treeAlgorithm;

import java.util.Arrays;

/**
 * 分别给你先序遍历的数组和中序遍历的数组，要求你构建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 二叉树的遍历顺序：
 * 先序：根左右
 * 中序：左根右
 * 后序：左右根
 *
 * 由先序遍历序列可以知道对应的根节点，而根节点在中序遍历序列中的位置就将左子树和右子树分割开来了。
 * 然后依次对左子树与右子树进行递归构建二叉树。
 */
public class ReConstructBinaryTree {
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,6,8};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        prePost(treeNode);

    }

    /**
     *
     * @param pre 先序遍历序列
     * @param in 中序遍历序列
     * @return
     */
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 || in.length == 0)
            return null;
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if(in[i] == pre[0]){
                //左子树,copyOfRange函数是左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                //递归构建左子树
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return root;
    }

    /**
     * 对构建的树进行先序遍历，验证结果
     * @param root
     */
    public static void prePost(TreeNode root){
        if(root == null)
            System.out.println("空树");
        System.out.println(root.val);

        if(root.left != null)
            prePost(root.left);

        if(root.right!= null)
            prePost(root.right);
    }
}
