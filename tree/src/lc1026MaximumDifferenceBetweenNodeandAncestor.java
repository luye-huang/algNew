//找diff等价于维护max min
public class lc1026MaximumDifferenceBetweenNodeandAncestor {
    private int diff = 0;

    public int maxAncestorDiff(TreeNode root) {
        compareDiff(root, root.val, root.val);
        return diff;
    }

    private void compareDiff(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        diff = Math.max(diff, max - min);
        compareDiff(root.left, min, max);
        compareDiff(root.right, min, max);
    }


    // This causes TLE, to many branches to take care of
//    private void compareDiff(TreeNode root, int val) {
//        if (root == null) {
//            return;
//        }
//        diff = Math.max(diff, Math.abs(val - root.val));
//        compareDiff(root.left, val);
//        compareDiff(root.left, root.val);
//        compareDiff(root.right, val);
//        compareDiff(root.right, root.val);
//    }
}
