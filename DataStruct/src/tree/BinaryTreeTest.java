package tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(1, "宋江");
        Node node1 = new Node(2, "卢俊义");
        Node node2 = new Node(3, "吴用");
        Node node3 = new Node(4, "林冲");
        Node node4 = new Node(5, "关胜");
        //Node node5 = new Node(6,"鲁智深");

        root.setLeft(node1);
        root.setRight(node2);
        node2.setRight(node4);
        node2.setLeft(node3);
        binaryTree.setRoot(root);
        System.out.println("先序：");
        binaryTree.preOrder();
        System.out.println("中序：");
        binaryTree.infixOrder();
        System.out.println("后序：");
        binaryTree.postOrder();
//        binaryTree.delNode(3);
//        System.out.println("***************");
//        binaryTree.preOrder();


    }
}

class BinaryTree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    //先序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("该树为空");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("该树为空");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("该树为空");
        }
    }

    //先序查找
    public Node preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序查找
    public Node infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序查找
    public Node postOrderSearch(int no) {
        if (root != null) {
            return this.postOrderSearch(no);
        } else {
            return null;
        }
    }

    //删除
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("空树~~");
        }
    }
}

class Node {
    private int no;
    private String name;
    private Node left;
    private Node right;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //先序遍历
    public void preOrder() {
        //输出父结点
        System.out.println(this);
        //先序遍历左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        //先序遍历右子树
        if (this.right != null) {
            this.right.preOrder();
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

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }
    //先序遍历查找

    /**
     * @param no 传入的要查找的编号
     * @return 找到返回该结点，未找到返回null
     */
    public Node preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        Node resNode = null;
        //向左子树递归
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //向右子树递归
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序查找
    public Node infixOrderSearch(int no) {
        Node resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序查找
    public Node postOrderSearch(int no) {
        Node resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

    //二叉树的删除结点
    //叶子结点直接删除，非叶子结点删除子树
    public void delNode(int no) {
        //
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }
}
