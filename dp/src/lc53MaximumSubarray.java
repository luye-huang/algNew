import org.junit.Test;

public class lc53MaximumSubarray {
    //状态:以当前元素为结尾的sum值
    // 每循环一个新的元素，要么需要加上前面元素为结尾的sum，要么不需要就是取当前值
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int memo = Math.max(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            memo = Math.max(memo, 0) + nums[i];
            sum = Math.max(sum, memo);
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println();
    }
}
