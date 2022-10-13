import java.util.HashMap;

public class lc662MaximumWidthofBinaryTree {
    HashMap<Integer, long[]> hashMap = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        long ret = 0;
        traverse(root, 0, 0);
        for (Integer i : hashMap.keySet()) {
            long vals[] = hashMap.get(i);
            ret = Math.max(ret, vals[1] - vals[0]);
        }
        return (int) ret + 1;
    }

    public void traverse(TreeNode root, int layer, long index) {
        if (root == null) {
            return;
        }
        if (hashMap.containsKey(layer)) {
            long vals[] = hashMap.get(layer);
            vals[0] = Math.min(vals[0], index);
            vals[1] = Math.max(vals[1], index);
            hashMap.put(layer, vals);
        } else {
            hashMap.put(layer, new long[]{index, index});
        }
        traverse(root.left, layer + 1, index << 1);
        traverse(root.right, layer + 1, (index << 1) + 1);
    }
}
