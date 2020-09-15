package treeAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class BSTtoDoubleLinkedList {
    //非递归方法的成员变量
    private static Queue<TreeNode> queue = new LinkedList<>();

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        midOrder(pRootOfTree);
        TreeNode head = queue.poll();
        TreeNode curr = head;
        while ( !queue.isEmpty()){
            TreeNode node = queue.poll();
            node.left = curr;
            curr.right = node;
            curr = node;
        }
        return head;
    }

    public static void midOrder(TreeNode root){
        if(root == null)
            return;
        midOrder(root.left);
        queue.offer(root);
        midOrder(root.right);
    }

    //递归方法的成员变量
    private TreeNode pre;
    //递归方法
    public TreeNode convertRec(TreeNode pRootOfTree){
        if(pRootOfTree == null)
            return null;
        convertRec(pRootOfTree.right);
        if(pre != null){
            pRootOfTree.right = pre;
            pre.left = pRootOfTree;
        }
        pre = pRootOfTree;
        convertRec(pRootOfTree.left);
        return pre;
    }
}
