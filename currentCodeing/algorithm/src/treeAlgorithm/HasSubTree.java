package treeAlgorithm;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubTree {
    public static boolean hasSubTree(TreeNode rootA, TreeNode rootB){
        if(rootA == null || rootB == null){
            return false;
        }
        //遍历A树，找到与B树根节点相同的子树
        if(rootA.val == rootB.val){
            //判断两颗子树是否相等
            if(judge(rootA,rootB)){
                return true;
            }
        }
        return hasSubTree(rootA.left,rootB) || hasSubTree(rootA.right,rootB);
    }

    private static boolean judge(TreeNode rootA, TreeNode rootB) {
        //判断两颗树是否相等
        //B树已经递归完全为空时说明前面已经匹配
        if(rootB == null){
            return true;
        }
        //A树已经为空了还在递归说明子树还未匹配完全
        if(rootA == null){
            return false;
        }
        //节点相等后判断左子树和右子树
        if(rootA.val == rootB.val){
            return judge(rootA.left,rootB.left) && judge(rootA.right,rootB.right);
        }
        //未匹配上
        return false;
    }
}
