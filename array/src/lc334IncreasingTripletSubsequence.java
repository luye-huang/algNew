public class lc334IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > secondMin) {
                return true;
            } else if (num < secondMin) {
                if (num < min) {
                    min = num;
                } else if (num > min) {
                    secondMin = num;
                }
            }
        }
        return false;
    }

    // dp TLE
//    public boolean increasingTriplet(int[] nums) {
//        int[] cache = new int[nums.length];
//        cache[0] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            int max = 1;
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) {
//                    max = Math.max(max, cache[j] + 1);
//                    if (max >= 3) {
//                        return true;
//                    }
//                }
//            }
//            cache[i] = max;
//        }
//        return false;
//    }
}
