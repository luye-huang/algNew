public class lc104MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int depth) {
        if (root == null) return depth;
        depth++;
        return Math.max(helper(root.left, depth), helper(root.right, depth));
    }
}
