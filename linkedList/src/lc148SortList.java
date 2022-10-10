import org.junit.Test;

public class lc148SortList {
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode node = head;
        while (node != null) {
            ListNode cur = dummy;
            while (true) {
                if (cur.next != null && cur.next.val > node.val) {
                    ListNode addedNode = new ListNode(node.val);
                    addedNode.next = cur.next;
                    cur.next = addedNode;
                    break;
                } else if (cur.next == null) {
                    cur.next = new ListNode(node.val);
                    break;
                } else {
                    cur = cur.next;
                }
            }
            node = node.next;
        }
        return dummy.next;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        return l1;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(4);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(1);
        node1.next.next.next = new ListNode(3);
//        node1.next.next.next.next = new ListNode(5);
        System.out.println(sortList(node1));

    }
}
