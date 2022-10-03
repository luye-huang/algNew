import org.junit.Test;

public class lc55JumpGame {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && nums[j] >= i - j;
                if (dp[i]) break;
            }
        }
        return dp[len - 1];
    }

//      using greed is better
//    public boolean canJump(int[] nums) {
//        int reachable = 0;
//        for (int i=0; i<nums.length; i++) {
//            if (i > reachable) return false;
//            reachable = Math.max(reachable, i + nums[i]);
//        }
//        return true;
//    }


    @Test
    public void test() {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{2, 3}));
    }
}
