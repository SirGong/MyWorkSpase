package binarysorttree;


public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断当前节点的值和当前子树的根节点的大小关系
        if (node.value < this.value) {
        if (this.left == null) {
            this.left = node;
        } else {
            //递归向左子树添加
            this.left.add(node);
        }
    } else {
        if (this.right == null) {
            this.right = node;
        } else {
            this.right.add(node);
        }
    }
}

    //查找
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    //查找父节点
    public Node searchParent(int value) {
        if ((this.left != null && value == this.left.value)
                || (this.right != null && value == this.right.value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;//没有父节点
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
