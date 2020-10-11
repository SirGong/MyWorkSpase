package treeAlgorithm;

import java.util.*;

public class PrintTree_Z {
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int level = 0;//标记层数
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size-- != 0){
                TreeNode node = queue.peek();
                queue.poll();
                list.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            level++;
            //偶数层，需要将结果反转
            if(level %2 == 0){
                Collections.reverse(list);
            }
            result.add(list);
        }
        return result;
    }
}
