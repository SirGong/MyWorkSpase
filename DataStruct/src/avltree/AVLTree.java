package avltree;

public class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

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
}
