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
            ret.add(permutations);
            return;
        }
        for (Integer num : nums) {
            LinkedList<Integer> newList = new LinkedList<>(nums);
            newList.remove(num);
            List<Integer> permutationsNew = new ArrayList<>(permutations);
            permutationsNew.add(num);
            backtrack(newList, permutationsNew);
        }
    }
}
