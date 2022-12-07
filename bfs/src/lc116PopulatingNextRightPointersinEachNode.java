import org.testng.annotations.Test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class lc116PopulatingNextRightPointersinEachNode {
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Deque<Node> nodes = new LinkedList<>();
        //此处用hashset不行，因为hashset add添加的元素乱序存在于hashset中
        Deque<Node> tmp = new LinkedList<>();
        nodes.add(root);
        while (true) {
            Node head = nodes.poll();
            if (head.left != null) {
                tmp.add(head.left);
                tmp.add(head.right);
            }
            while (!nodes.isEmpty()) {
                Node next = nodes.poll();
                if (next.left != null) {
                    tmp.add(next.left);
                    tmp.add(next.right);
                }
                head.next = next;
                head = next;
            }
            if (tmp.isEmpty()) {
                break;
            } else {
                nodes.addAll(tmp);
                tmp.clear();
            }
        }
        return root;
    }

    @Test
    public void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        Node node = connect(node1);
        System.out.println();

    }
}
