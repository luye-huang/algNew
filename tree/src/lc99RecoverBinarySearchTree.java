import org.junit.Test;

public class lc99RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
//        swapHelper(root.left, root.val, true);
//        swapHelper(root.right, root.val, false);
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.left.val > root.val) {
                int temp = root.left.val;
                root.left.val = root.val;
                root.val = temp;
            }
        }
        if (root.right != null) {
            if (root.right.val < root.val) {
                int temp = root.right.val;
                root.right.val = root.val;
                root.val = temp;
                if (root.left != null) {
                    if (root.left.val > root.val) {
                        temp = root.left.val;
                        root.left.val = root.val;
                        root.val = temp;
                    }
                }
            }
        }
        recoverTree(root.left);
        recoverTree(root.right);
    }

    private Integer swapHelper(TreeNode root, int val, boolean less) {
        if (root == null) {
            return null;
        }
        int pushDownValue = root.val;
        if (less) {
            pushDownValue = Math.min(val, root.val);
        } else {
            pushDownValue = Math.max(val, root.val);
        }
        Integer left = swapHelper(root.left, pushDownValue, true);
        Integer right = swapHelper(root.right, pushDownValue, false);
//        if (root.left != null && root.left.val > val) {
//            swapHelper(root.left, root.val);
//        }
        if (left != null && left > root.val) {
            root.val = left;
        }
        if (right != null && right < root.val) {
            root.val = right;
        }
        return root.val;
//        return null;
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node2.right = node3;
        recoverTree(node1);
        System.out.println();
        System.out.println();
    }
}
