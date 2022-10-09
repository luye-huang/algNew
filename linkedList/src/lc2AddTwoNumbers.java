import org.junit.Test;

public class lc2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode node = head;
        int inc = 0;
        while (l1 != null || l2 != null) {
            int v1 = 0, v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int val = v1 + v2 + inc;
            if (val > 9) {
                val -= 10;
                inc = 1;
            } else {
                inc = 0;
            }
            node.next = new ListNode(val);
            node = node.next;
        }
        if (inc > 0) {
            node.next = new ListNode(1);
        }
        return head.next;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        System.out.println(addTwoNumbers(node1, node4));
        System.out.println();
    }
}
