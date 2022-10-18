import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class lc78Subsets {
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new ArrayList<Integer>());
        return ret;
    }

    private void backtrack(int index, int[] nums, List<Integer> subset) {
        if (index == nums.length) {
            ret.add(new ArrayList<>(subset));
            return;
        }
        backtrack(index + 1, nums, subset);
        subset.add(nums[index]);
        backtrack(index + 1, nums, subset);
        subset.remove(subset.size() - 1);
    }

    @Test
    public void test() {
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println();
    }
}
