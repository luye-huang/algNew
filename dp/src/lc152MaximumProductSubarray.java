public class lc152MaximumProductSubarray {
    // 状态：每个num结尾的乘积正数最大和负数最小（绝对值最大的两种情况）
    // 选择：如果num为正，则与正数最大的前一个状态相乘，再与本身比较，得到最值。为负，情况类似
    // https://leetcode.com/problems/maximum-product-subarray/solutions/2902584/java-3ms-dp-solution/
    public int maxProduct(int[] nums) {
        int[] maxPositiveValues = new int[nums.length];
        int[] minNegativeValues = new int[nums.length];
        int ret = nums[0];
        if (nums[0] > 0) {
            maxPositiveValues[0] = nums[0];
        } else {
            minNegativeValues[0] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                maxPositiveValues[i] = Math.max(nums[i], nums[i] * maxPositiveValues[i - 1]);
                minNegativeValues[i] = nums[i] * minNegativeValues[i - 1];
            } else if (nums[i] < 0) {
                maxPositiveValues[i] = nums[i] * minNegativeValues[i - 1];
                minNegativeValues[i] = Math.min(nums[i], nums[i] * maxPositiveValues[i - 1]);
            }
            ret = Math.max(ret, maxPositiveValues[i]);
        }
        return ret;
    }
}
