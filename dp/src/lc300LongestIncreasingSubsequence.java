import org.junit.Test;
import java.util.ArrayList;


//当前状态为前面每一个元素为最后元素的状态的最值
public class lc300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] cache = new int[nums.length];
        cache[0] = 1;
        int ret = 1;
        for (int i = 1; i < nums.length; i++) {
            int curLen = 1;
            //从后往前循环时，如果后面的值如果比前面的大，则计算后面的值就会包含前面的情况，则可跳过
            int curMaxCalculatedVal = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && curMaxCalculatedVal < nums[j]) {
                    curLen = Math.max(curLen, cache[j] + 1);
                    curMaxCalculatedVal = nums[j];
                }
            }
            cache[i] = curLen;
            ret = Math.max(ret, curLen);
        }
        return ret;
    }


    @Test
    public void test() {
//        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//        System.out.println(lengthOfLIS(new int[]{0}));
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
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
