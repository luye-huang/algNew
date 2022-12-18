import org.junit.Test;

import java.util.HashMap;

//https://leetcode.com/problems/subarray-sum-equals-k/solutions/102106/java-solution-presum-hashmap/

public class lc560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int ret = 0, sum = 0;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (preSum.containsKey(sum - k)) {
                ret += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return ret;
    }

    @Test
    public void test() {
        System.out.println(subarraySum(new int[]{1, 2, 3, -1}, 2));

    }
}
