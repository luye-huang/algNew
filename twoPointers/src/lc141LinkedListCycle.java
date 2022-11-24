public class lc141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode left = head;
        ListNode right = head;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
            if (left == right) {
                return true;
            }
        }
        return false;
    }


//    public boolean hasCycle(ListNode head) {
//        while (head != null) {
//            if (head.val == 1_000_000) return true;
//            head.val = 1_000_000;
//            head = head.next;
//        }
//        return false;
//    }
}
