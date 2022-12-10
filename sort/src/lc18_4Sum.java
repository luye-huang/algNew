import org.junit.Test;

import java.util.*;

public class lc18_4Sum {
    List<List<Integer>> ret = new LinkedList<>();
    HashSet<List<Integer>> hashSet = new HashSet<>();
    HashMap<Long, Integer> cache = new HashMap<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int num : nums) {
            cache.put((long) num, cache.getOrDefault(num, 0) + 1);
        }
        seekNSum(nums, target, 4, 0, new ArrayList<>());
        ret.addAll(hashSet);
        return ret;
    }

    private void seekNSum(int[] nums, long target, int n, int index, List<Integer> list) {
        for (int i = index; i < nums.length - (n - 1); ) {
            if (target < n * (long) nums[i] || target > n * (long) nums[nums.length - 1]) {
                return;
            }
            if (n == 2) {
                long offset = target - nums[i];
                if ((offset > nums[i] || offset == nums[i] && nums[i] == nums[i + 1]) && cache.containsKey(offset)) {
                    List<Integer> newList = new LinkedList<>(list);
                    newList.add(nums[i]);
                    newList.add((int) offset);
                    hashSet.add(newList);
                }
                i += cache.get((long) nums[i]);
            } else {
                list.add(nums[i]);
                seekNSum(nums, target - nums[i], n - 1, ++i, list);
                list.remove(list.size() - 1);
            }
        }
    }

    @Test
    public void test() {
//        System.out.println(fourSum(new int[]{0, 0, 0, -1000000000, -1000000000, -1000000000, -1000000000}, -1000000000));
//        System.out.println(fourSum(new int[]{-1000000000, -1000000000, -1000000000, -1000000000}, 294967296));
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));

    }
}
