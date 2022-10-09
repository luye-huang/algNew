import org.junit.Test;

public class lc19RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode right = head;
        ListNode left = dummy;
        while (right != null) {
            right = right.next;
            if (--n < 0) {
                left = left.next;
            }
        }
        left.next = left.next == null ? null : left.next.next;
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
//        System.out.println(removeNthFromEnd(node1, 2));
        System.out.println(removeNthFromEnd(new ListNode(1), 1));
        System.out.println();
    }
}
