import org.junit.Test;

public class lc237DeleteNodeinaLinkedList {
    //next传递赋值，删除最后节点
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        while (next != null && next.next != null) {
            node.val = next.val;
            node = node.next;
            next = next.next;
        }
        node.val = next.val;
        node.next = null;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(4);
        node1.next = new ListNode(5);
        node1.next.next = new ListNode(1);
        node1.next.next.next = new ListNode(9);
//        node1.next.next = null;
//        node1.next.next.next.next = new ListNode(5);
        deleteNode(node1.next);
        System.out.println();

    }
}
