import org.junit.Test;

public class lc105ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh) {
        if (preLow > preHigh || inLow > inHigh) return null;
        TreeNode root = new TreeNode(preorder[preLow]);

        int inorderRoot = inLow;
        for (int i = inLow; i <= inHigh; i++) {
            if (inorder[i] == root.val) {
                inorderRoot = i;
                break;
            }
        }

        int leftTreeLen = inorderRoot - inLow;
        root.left = build(preorder, preLow + 1, preLow + leftTreeLen, inorder, inLow, inorderRoot - 1);
        root.right = build(preorder, preLow + leftTreeLen + 1, preHigh, inorder, inorderRoot + 1, preHigh);
        return root;
    }

    @Test
    public void test() {
//        TreeNode test = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
//        TreeNode test = buildTree(new int[]{1, 7}, new int[]{7, 1});
//        TreeNode test = buildTree(new int[]{1, 7}, new int[]{1, 7});
//        TreeNode test = buildTree(new int[]{4, 3, 2, 1}, new int[]{1, 2, 3, 4});
//        TreeNode test = buildTree(new int[]{3, 1, 2, 4}, new int[]{1, 2, 3, 4});
        TreeNode test = buildTree(new int[]{1, 4, 3, 2, 5}, new int[]{1, 2, 3, 4, 5});
        System.out.println();
    }
}
