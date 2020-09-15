package treeAlgorithm;

import java.util.ArrayList;

public class FindPathTreeSum {

    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null)
            return result;
        list.add(root.val);
        target = target-root.val;
        //每次找到一个路径就将list集合添加到结果当中去
        if(target == 0 && root.left==null&&root.right==null)
            result.add(new ArrayList<Integer>(list));
        //向左子树和向右子树递归
        FindPath(root.left,target);
        FindPath(root.right,target);
        //在回溯的过程中要将已经添加到list中的节点删除，继续存放兄弟节点
        list.remove(list.size()-1);
        return result;
    }
}
