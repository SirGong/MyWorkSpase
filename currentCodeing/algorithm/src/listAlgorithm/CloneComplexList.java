package listAlgorithm;

import java.util.HashMap;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class CloneComplexList {

    public RandomListNode Clone(RandomListNode pHead) {
        //利用HashMap保存所所有的节点
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode p = pHead;
        while (p!=null){
            RandomListNode newNode = new RandomListNode(p.label);
            map.put(p,newNode);
            p = p.next;
        }
        p = pHead;
        //为新节点赋值
        while (p!=null){
            RandomListNode newNode = map.get(p);
            newNode.next = (p.next == null?null:map.get(p.next));
            newNode.random = (p.random == null?null:map.get(p.random));
            p = p.next;
        }
        return map.get(pHead);
    }
}
 class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
