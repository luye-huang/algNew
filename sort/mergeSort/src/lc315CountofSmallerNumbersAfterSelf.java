import org.junit.Test;

import java.util.*;

public class lc315CountofSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        Deque<Integer> list = new LinkedList<>();
        List<Integer> mono = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int idx = 0, count = 0;
            while (idx < mono.size()) {
                if (mono.get(idx) >= nums[i]) {
                    idx++;
                    count++;
                } else {
                    break;
                }
            }
            mono.add(idx, nums[i]);
            list.addFirst(nums.length - 1 - i - count);
//            list.add(0, nums.length - 1 - i - count);
        }
        return (List<Integer>) list;
    }

    @Test
    public void test() {
        System.out.println();

    }
}
