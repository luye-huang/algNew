import org.junit.Test;

public class lc124BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int ret = root.val;
        if (root.left != null) {
            ret = Math.max(ret, maxPathSum(root.left));
            ret = Math.max(ret, root.val + maxPathSum(root.left));
            if (root.right != null) {
                ret = Math.max(ret, root.val + maxPathSum(root.left) + maxPathSum(root.right));

            }
        }
        if (root.right != null) {
            ret = Math.max(ret, maxPathSum(root.right));
            ret = Math.max(ret, root.val + maxPathSum(root.right));
        }
        return ret;
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(maxPathSum(node1));
        System.out.println();
    }
}
