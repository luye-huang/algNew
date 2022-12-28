import java.util.HashMap;

public class lc268MissingNumber {
    public int missingNumber(int[] nums) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            hashMap.put(num, true);
            if (max < num) {
                max = num;
            }
        }
        for (int num : nums) {
            int tmp = num + 1;
            if (!hashMap.containsKey(tmp) && tmp < max) {
                return tmp;
            }
            tmp = num - 1;
            if (!hashMap.containsKey(tmp) && tmp >= 0) {
                return tmp;
            }
        }
        return max + 1;
    }
}
