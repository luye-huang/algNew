import org.testng.annotations.Test;

public class lc142LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (fast != null && fast.next != null) {
                    if (slow == fast) return slow;
                    slow = slow.next;
                    fast = fast.next;
                }
            }
        }
        return null;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.next = node1;
        ListNode ret = detectCycle(node1);
        System.out.println();

    }
}
