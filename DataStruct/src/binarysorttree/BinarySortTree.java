package binarysorttree;

public class BinarySortTree {
    private Node root;

    //添加节点
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //遍历
    public void infixOrder() {
        if (root == null) {
            System.out.println("空树");
        } else {
            root.infixOrder();
        }
    }

    //查找节点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }
    //编写方法：返回以node节点的树的最小节点的值   删除值最小的节点
    public int delRightTreeMin(Node node){
        Node target = node;
        while (target.left!=null){
            target = target.left;
        }
        //删除
        delNode(target.value);
        return target.value;
    }
    //删除结点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //待删节点
            Node targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //待删节点的父节点
            Node parent = searchParent(value);
            //待删节点是叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {//待删除的节点有两颗子树
                int min = delRightTreeMin(targetNode.right);//找到targetNode的右子树的最小值
                targetNode.value=min;
            } else {//待删节点只有一颗子树
                if (targetNode.left != null) {//待删节点有左子节点
                    if(parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    }else {
                        root = targetNode.left;
                    }
                } else {//待删节点有右子节点
                   if(parent != null){
                       if (parent.left.value == value) {
                           parent.left = targetNode.right;
                       } else {
                           parent.right = targetNode.right;
                       }
                   }else {
                       root = targetNode.right;
                   }
                }
            }
        }
    }
}
