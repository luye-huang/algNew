public class lc206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode listNode = new ListNode();
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = listNode.next;
            listNode.next = tmp;
        }
        return listNode.next;
    }
}
