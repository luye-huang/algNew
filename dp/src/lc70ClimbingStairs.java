public class lc70ClimbingStairs {
//    public int climbStairs(int n) {
//        if (n <= 2) {
//            return n;
//        }
//        int[] cache = new int[n + 1];
//        cache[1] = 1;
//        cache[2] = 2;
//        for (int i = 3; i < n + 1; i++) {
//            cache[i] = cache[i - 1] + cache[i - 2];
//        }
//        return cache[n];
//    }

    //比上个算法压缩了cache空间，提高cache重用率
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int left = 1, right = 2;
        for (int i = 3; i < n + 1; i++) {
            int temp = right;
            right = left + right;
            left = temp;
        }
        return right;
    }
}
