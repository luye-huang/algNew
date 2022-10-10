import org.junit.Test;

public class lc124BinaryTreeMaximumPathSum {
    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    //Each node actually has two roles when it comes to function maxPathDown.
    // When processing the final result maxValue, the node is treated as the highest point of a path.
    // When calculating its return value, it is only part of a path (left or right part), and this return value will be used to calculate path sum of other paths with some other nodes(above the current one) as their highest point.
    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
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
