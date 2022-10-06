import org.junit.Test;

public class lc198HouseRobber {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (len == 3) {
            return Math.max(nums[0] + nums[2], nums[1]);
        }
        int prev3 = nums[0], prev2 = Math.max(nums[0], nums[1]), prev1 = Math.max(prev2, nums[2] + nums[0]);
        for (int i = 3; i < nums.length; i++) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + nums[i]);
            prev1 = Math.max(prev1, prev3 + nums[i]);
            prev2 = temp;
            prev3 = prev2;
        }
        return Math.max(prev1, prev2);
    }

    @Test
    public void test() {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println();
    }
}
