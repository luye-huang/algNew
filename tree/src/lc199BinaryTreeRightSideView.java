import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 用个队列，每层返回最右边的。add offer方法都会添加null值，size会增加
public class lc199BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.offer(root);
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            ret.add(deque.peekLast().val);
            while (size > 0) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                size--;
            }
        }
        return ret;
    }

    @Test
    public void test() {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(null);
        System.out.println(deque.isEmpty());

    }
}
