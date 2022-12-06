import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
//当前状态为前面每一个元素为最后元素的状态的最值
public class lc300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, 1);
        int ret = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    cache[i] = Math.max(cache[i], cache[j] + 1);
                }
            }
            ret = Math.max(ret, cache[i]);
        }
        return ret;
    }


    @Test
    public void test() {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//        System.out.println(lengthOfLIS(new int[]{0}));
//        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println();
    }

    @Test
    public void testRemoveList() {
        ArrayList<Integer> cache = new ArrayList<>();
        cache.add(0);
        cache.add(1);
        cache.add(2);
        cache.add(3);
//        for (int i = cache.size() - 1; i >= 0; i--) {
//            System.out.println("deleted  " + cache.get(0) + "   " + cache.size());
//            cache.remove(i);
//        }

        for (int i = 0; i < cache.size(); i++) {
            System.out.println("deleted  " + cache.get(0) + "   " + cache.size());
            cache.remove(i);
            i--;
        }
    }
}
