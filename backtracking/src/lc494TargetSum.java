import org.testng.annotations.Test;

import java.util.ArrayList;

public class lc494TargetSum {
    int ret = 0;

    public int findTargetSumWays(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            int i = 0;
            while (i < list.size()) {
                if (list.get(i) > num) {
                    i++;
                } else {
                    break;
                }
            }
            list.add(i, num);
        }
        backtrack(list, 0, target);
        return ret;
    }

    public void backtrack(ArrayList<Integer> nums, int index, int target) {
        if (index == nums.size() - 1) {
            if (nums.get(index) == target) {
                ret++;
            }
            if (nums.get(index) == -target) {
                ret++;
            }
            return;
        }
        //按绝对值排序，后面的绝对值小，如果target过于大，则后面可能无法满足提前退出
        if (Math.abs(target) > (nums.size() - index) * Math.abs(nums.get(index))) {
            return;
        }
        backtrack(nums, index + 1, target - nums.get(index));
        backtrack(nums, index + 1, target + nums.get(index));
    }

    @Test
    public void test() {
//        System.out.println(findTargetSumWays(new int[]{1, 2, 3, 6, 2, 18, 3}, 3));
//        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(findTargetSumWays(new int[]{1, 0}, 1));
    }
}
