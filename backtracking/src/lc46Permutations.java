import org.junit.Test;

import java.util.*;

public class lc46Permutations {
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }
        backtrack(list, new ArrayList<>());
        return ret;
    }

    private void backtrack(List<Integer> nums, List<Integer> permutations) {
        if (nums.isEmpty()) {
            ret.add(new ArrayList<>(permutations));
            return;
        }
        for (Integer num : nums) {
            LinkedList<Integer> newList = new LinkedList<>(nums);
            newList.remove(num);
            permutations.add(num);
            backtrack(newList, permutations);
            permutations.remove(num);
        }
    }

    @Test
    public void test() {
        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println();
    }
}
