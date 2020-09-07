package avltree;

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
        //添加完一个节点之后，如果（右子树的高度-左子树的高度）>1，左旋转
        if (rightHeight() - leftHeight() > 1) {
            //如果他的右子树的左子树的高度大于他的右子树的右子树的高度
            if (right != null && right.leftHeight() > right.rightHeight()) {
                //对当前节点的右子树进行右旋转
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
            return;//结束该方法，防止进入下一个分支
        }
        //添加完一个节点之后，如果（左子树的高度-右子树的高度）>1，右旋转
        if (leftHeight() - rightHeight() > 1) {
            //如果当前节点的左子树的右子树的高度大于它的左子树的左子树的高度
            if (left != null && left.rightHeight() > left.leftHeight()) {
                //当前节点的左子树行左旋转
                left.leftRotate();
                rightRotate();
            } else {
                rightRotate();
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

    //返回树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    //返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //左旋转方法
    private void leftRotate() {
        //创建新的结点
        Node newNode = new Node(value);
        //把新的结点的左子树设置成当前节点的左子树
        newNode.left = left;
        //把新的结点的右子树设置成当前节点的右子树的左子树
        newNode.right = right.left;
        //把当前节点的值换成右子节点的值
        value = right.value;
        //把当前节点的右子树设置成当前节点的右子树的右子树
        right = right.right;
        //把当前节点的左子树设置成新节点
        left = newNode;
    }

    //右旋转
    private void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
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
