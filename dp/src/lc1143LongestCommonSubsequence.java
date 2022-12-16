import org.junit.Test;

public class lc1143LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] cache = new int[2][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    cache[i % 2][j] = cache[(i - 1) % 2][j - 1] + 1;
                } else {
                    cache[i % 2][j] = Math.max(cache[(i - 1) % 2][j], cache[i % 2][j - 1]);
                }
            }
        }
        return cache[text1.length() % 2][text2.length()];
    }

    @Test
    public void test() {
        System.out.println(11);
        System.out.println(longestCommonSubsequence("abcde", "ace"));

    }
}
