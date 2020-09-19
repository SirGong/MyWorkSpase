package listAlgorithm;

import sun.util.resources.cldr.uk.CurrencyNames_uk;

public class FindTheFirstCommonNode {
    public Node FindFirstCommonNode(Node pHead1, Node pHead2) {

        //统计两个链表的长度
        int lengthLong = getLength(pHead1);
        int lengthShort = getLength(pHead2);

        Node longListHead = pHead1;
        Node shortListHead = pHead2;
        int lengthDif = lengthLong - lengthShort;
        if (lengthLong < lengthShort) {
            longListHead = pHead2;
            shortListHead = pHead1;
            lengthDif = lengthShort - lengthLong;
        }
        for (int i = 0; i < lengthDif; i++) {
            longListHead = longListHead.next;
        }
        while ((longListHead!=null) && (shortListHead!= null) && (longListHead!=shortListHead)){
            longListHead = longListHead.next;
            shortListHead = shortListHead.next;
        }
        return longListHead;
    }

    public static int getLength(Node head) {
        if (head == null) {
            return -1;
        }
        int count = 1;
        Node curr = head;
        while (curr.next != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
