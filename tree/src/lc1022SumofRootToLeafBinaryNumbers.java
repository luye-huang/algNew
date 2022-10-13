import org.junit.Test;

public class lc1022SumofRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        return getPathValue(root, 0);
    }

    private int getPathValue(TreeNode root, int val) {
        int cur = val << 1 | root.val;
        int left = root.left == null ? 0 : getPathValue(root.left, cur);
        int right = root.right == null ? 0 : getPathValue(root.right, cur);
        return root.left == null && root.right == null ? cur : left + right;
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(sumRootToLeaf(node1));
        System.out.println();
        System.out.println();
    }
}
