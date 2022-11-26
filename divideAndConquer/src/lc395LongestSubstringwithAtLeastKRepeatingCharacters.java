import org.junit.Test;

public class lc395LongestSubstringwithAtLeastKRepeatingCharacters {
    //按照unique字符的个数分治，里面用滑动窗口
    //当unique小于等于当前uniquer时，扩大窗口
    //当unique大于当前unique时，压缩窗口。
    public int longestSubstring(String s, int k) {
        int left, right, unique, moreThanK;
        int ret = 0;
        for (int i = 1; i <= 26; i++) {
            left = 0;
            right = 0;
            unique = 0;
            moreThanK = 0;
            int[] counts = new int[26];
            while (right < s.length()) {
                if (unique <= i) {
                    char c = s.charAt(right);
                    int idx = c - 'a';
                    if (++counts[idx] == 1) {
                        unique++;
                    }
                    if (counts[idx] == k) {
                        moreThanK++;
                    }
                    //缩减窗口时，不会触发此结果比较。因为是在右边增加第一个时，左边至少减去一个才会一样多  ***
                    if (moreThanK == unique && unique == i) {
                        ret = Math.max(ret, right - left + 1);
                    }
                    right++;
                } else {
                    char c = s.charAt(left);
                    int idx = c - 'a';
                    if (--counts[idx] == 0) {
                        unique--;
                    }
                    if (counts[idx] == k - 1) {
                        moreThanK--;
                    }
                    left++;
                }
            }
        }
        return ret;
    }

    @Test
    public void test() {
//        System.out.println(longestSubstring("ababbc", 2));
//        System.out.println();
    }
}
