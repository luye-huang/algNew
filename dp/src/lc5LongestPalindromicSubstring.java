import org.junit.Test;

public class lc5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1) ? s : s.substring(0, 1);
        }
        int start = 0, maxLength = s.charAt(0) == s.charAt(1) ? 2 : 1;
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            dp[i][0] = 0;
        }
        for (int i = 3; i <= s.length(); i++) {
            for (int j = i - 1; j > 0; j--) {
                if (s.charAt(j - 1) == s.charAt(i - 1)) {
                    if (j + 1 == i) {
                        dp[j][i] = 2;
                    } else if (dp[j + 1][i - 1] > 0) {
                        dp[j][i] = dp[j + 1][i - 1] + 2;
                    }
                    if (dp[j][i] > maxLength) {
                        maxLength = dp[j][i];
                        start = j - 1;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }


    @Test
    public void test() {
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("aab"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("bananas"));
        System.out.println(longestPalindrome("aacabdkacaa"));
    }
}
