package listAlgorithm;

public class MergeList {

    public static Node merge(Node head1, Node head2) {
        Node newHead = new Node(0);
        Node current = newHead;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        if (head1 == null)
            current.next = head2;
        if (head2 == null)
            current.next = head1;
        return newHead.next;
    }

    public static Node mergeRec(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        } else {
            if (head1.val < head2.val) {
                head1.next = mergeRec(head1.next, head2);
                return head1;
            } else {
                head2.next = mergeRec(head1, head2.next);
                return head2;
            }
        }
    }
}
