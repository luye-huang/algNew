import org.junit.Test;

import java.util.HashMap;

//寻找两部分的最大乘积，等价于寻找一部分最接近总的和二分之一的值
public class lc1339MaximumProductofSplittedBinaryTree {
    private long sum;
    private long closet2Mid = Long.MAX_VALUE;
    private float diffWithMid = Float.MAX_VALUE;

    HashMap<TreeNode, Long> cache = new HashMap<>();

    public int maxProduct(TreeNode root) {
        sum = traverse4Sum(root);
        traverse4Max(root, (float) sum / 2);
        return (int) (((sum - closet2Mid) * closet2Mid) % ((int) Math.pow(10, 9) + 7));
    }

    private long traverse4Sum(TreeNode root) {
        if (root == null) return 0;
        long nodeSum = traverse4Sum(root.left) + traverse4Sum(root.right) + root.val;
        //第一次遍历时，把sum记录
        cache.put(root, nodeSum);
        //注意int累加过大，造成精度丢失
        return nodeSum;
    }

    private void traverse4Max(TreeNode root, float mid) {
        if (root.left != null) {
            long leftSum = cache.get(root.left);
            //判断是不是最接近中间值
            if (Math.abs(leftSum - mid) < diffWithMid) {
                diffWithMid = Math.abs(leftSum - mid);
                closet2Mid = leftSum;
            }
            if (leftSum > mid) {
                traverse4Max(root.left, mid);
            }
        }
        if (root.right != null) {
            long rightSum = cache.get(root.right);
            if (Math.abs(rightSum - mid) < diffWithMid) {
                diffWithMid = Math.abs(rightSum - mid);
                closet2Mid = rightSum;
            }
            if (rightSum > mid) {
                traverse4Max(root.right, mid);
            }
        }
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        System.out.println(maxProduct(node1));
    }

    @Test
    public void test2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.right = node2;

        node2.left = node3;
        node2.right = node4;
        node4.left = node5;
        node4.right = node6;
        System.out.println(maxProduct(node1));

    }
}
