package tree;


public class ThreadBinaryThreeTest {
    public static void main(String[] args) {
        Nodes root = new Nodes(1, "tom");
        Nodes nodes2 = new Nodes(3, "tom");
        Nodes nodes3 = new Nodes(6, "tom");
        Nodes nodes4 = new Nodes(8, "tom");
        Nodes nodes5 = new Nodes(10, "tom");
        Nodes nodes6 = new Nodes(14, "tom");

        root.setLeft(nodes2);
        root.setRight(nodes3);
        nodes2.setLeft(nodes4);
        nodes2.setRight(nodes5);
        nodes3.setLeft(nodes6);

        //测试线索化
        ThreadBinaryThree threadBinaryThree = new ThreadBinaryThree();
        threadBinaryThree.setRoot(root);
        threadBinaryThree.threadNodes();

        System.out.println(nodes5.getLeft());
        System.out.println(nodes5.getRight());
        System.out.println("~~~~~~~~~~~~~~~~~~");
        threadBinaryThree.threadList();


    }
}

//线索化二叉树
class ThreadBinaryThree {
    private Nodes root;
    private Nodes pre = null;//线索化是需要该指针指向当前节点的前一个节点

    public void setRoot(Nodes root) {
        this.root = root;
    }

    public void threadNodes() {
        this.threadNodes(root);
    }

    //中序线索化二叉树的方法
    public void threadNodes(Nodes nodes) {
        //如果nodes为空，不能线索化
        if (nodes == null) {
            return;
        }
        //线索化左子树
        threadNodes(nodes.getLeft());
        //线索化当前节点
        if (nodes.getLeft() == null) {
            //让当前节点的左指针指向前驱pre
            nodes.setLeft(pre);
            //修改当前指针的类型
            nodes.setLeftType(1);
        }
        //处理后继节点
        if (pre != null && pre.getRight() == null) {
            //前驱结点的右指针指向当前节点
            pre.setRight(nodes);
            pre.setRightType(1);
        }
        //每处理一个节点之后，让当前节点是下一个节点的前驱结点
        pre = nodes;
        //线索化右子树
        threadNodes(nodes.getRight());
    }

    //遍历线索化二叉树（中序线索二叉树）
    public void threadList() {
        //从root开始遍历
        Nodes node = root;
        while (root != null) {
            //root不为空,找到开始的第一个节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //打印当前节点
            System.out.println(node);
            //如果当前节点的右指针是指向后继节点，就一直输出
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();

        }
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
    public Nodes preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序查找
    public Nodes infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序查找
    public Nodes postOrderSearch(int no) {
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

//节点
class Nodes {
    private int no;
    private String name;
    private Nodes left;
    private Nodes right;
    //leftType = 0 表示left指向左子树，leftType = 1 表示指向前驱节点
    //rightType = 0 表示left指向右子树，rightType = 1 表示指向后继节点
    int leftType;
    int rightType;

    public Nodes(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
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

    public Nodes getLeft() {
        return left;
    }

    public void setLeft(Nodes left) {
        this.left = left;
    }

    public Nodes getRight() {
        return right;
    }

    public void setRight(Nodes right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Nodes{" +
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
    public Nodes preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        Nodes resNode = null;
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
    public Nodes infixOrderSearch(int no) {
        Nodes resNode = null;
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
    public Nodes postOrderSearch(int no) {
        Nodes resNode = null;
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
