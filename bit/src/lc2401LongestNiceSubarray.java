import org.junit.Test;

public class lc2401LongestNiceSubarray {
    public int longestNiceSubarray(int[] nums) {
        int AND = 0, left = 0, res = 0, n = nums.length;
        for (int right = 0; right < n; ++right) {
            while ((AND & nums[right]) > 0)
                AND ^= nums[left++];
            AND |= nums[right];
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(longestNiceSubarray(new int[]{1, 3, 8, 48, 10}));
        System.out.println(longestNiceSubarray(new int[]{744437702, 379056602, 145555074, 392756761, 560864007, 934981918, 113312475, 1090, 16384, 33, 217313281, 117883195, 978927664}));
    }
}
