import org.junit.Test;

public class lc230KthSmallestElementInBST {
    int count = 0;
    int ret;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return ret;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null || count > k) {
            return;
        }
        traverse(root.left, k);
        if (++count == k) {
            ret = root.val;
        }
        traverse(root.right, k);
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
//        node3.left = node4;
        node2.right = node4;

        System.out.println(kthSmallest(node1, 1));
        System.out.println();
    }

}
