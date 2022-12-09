import java.util.ArrayList;
import java.util.List;

public class lc872LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        addLeaf(root1, list1);
        addLeaf(root2, list2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).val != list2.get(i).val) {
                return false;
            }
        }
        return true;
    }

    private void addLeaf(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root);
        }
        addLeaf(root.left, list);
        addLeaf(root.right, list);
    }
}
