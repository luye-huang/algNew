import java.util.HashMap;

public class lc337HouseRobberIII {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int rob(TreeNode root) {
        //这一层节点被抢的最大抢劫收获
        HashMap<TreeNode, Integer> robbedHashMap = new HashMap<>();
        //这一层节点没被抢的最大抢劫收获
        HashMap<TreeNode, Integer> unrobbedHashMap = new HashMap<>();
        return Math.max(rob(root, true, robbedHashMap, unrobbedHashMap), rob(root, false, robbedHashMap, unrobbedHashMap));
    }

    private int rob(TreeNode root, boolean robbing, HashMap<TreeNode, Integer> robbed, HashMap<TreeNode, Integer> unrobbed) {
        if (root == null) {
            return 0;
        }
        if (robbing) {
            if (robbed.containsKey(root)) {
                return robbed.get(root);
            }
            int val = root.val + rob(root.left, false, robbed, unrobbed) + rob(root.right, false, robbed, unrobbed);
            robbed.put(root, val);
            return val;
        } else {
            if (unrobbed.containsKey(root)) {
                return unrobbed.get(root);
            }
            int val = Math.max(rob(root.left, true, robbed, unrobbed), rob(root.left, false, robbed, unrobbed)) + Math.max(rob(root.right, true, robbed, unrobbed), rob(root.right, false, robbed, unrobbed));
            unrobbed.put(root, val);
            return val;
        }
    }
}
