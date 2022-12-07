public class lc938RangeSumofBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int val = root.val >= low && root.val <= high ? root.val : 0;
        return val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
