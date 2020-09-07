package huffmanTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CreatHuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = creatHuffmanTree(arr);
        preOrder(root);
    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树无法遍历~~");
        }
    }

    public static Node creatHuffmanTree(int[] arr) {
        //构建集合，存放结点
        List<Node> nodes = new ArrayList<>();
        //将数组构建成结点，并放入集合进行排序
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        //只要集合中只剩下最后一个元素，就退出
        while (nodes.size() > 1) {
            //将集合升序排序
            Collections.sort(nodes);
            //取出最小和次小的元素
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //以这两个结点构建一颗新的二叉树，新节点的值为两个节点的权值相加
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //删除取出的两个节点，添加新的节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        //返回赫夫曼树的根节点
        return nodes.get(0);
    }
}
