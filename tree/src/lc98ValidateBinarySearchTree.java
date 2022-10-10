import org.junit.Test;

public class lc98ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return checkHelper(root.left, Long.MIN_VALUE, root.val) && checkHelper(root.right, root.val, Long.MAX_VALUE);
    }

    private boolean checkHelper(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }
        if (node.val <= left  || node.val >= right ) {
            return false;
        }
        return checkHelper(node.left, left, node.val) && checkHelper(node.right, node.val, right);
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
//        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
//        node3.left = node4;
//        node3.right = node5;

        System.out.println(isValidBST(node1));
        System.out.println();
    }
}
