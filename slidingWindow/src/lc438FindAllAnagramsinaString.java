import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class lc438FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new LinkedList<>();
        int[] unmatched = new int[26];
        int[] original = new int[26];
        int matched = 0;
        for (int i = 0; i < p.length(); i++) {
            ++unmatched[p.charAt(i) - 'a'];
            ++original[p.charAt(i) - 'a'];
        }
        int left = 0, right = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            if (original[r - 'a'] == 0) {
                left = ++right;
                unmatched = original.clone();
                matched = 0;
                continue;
            }
            if (--unmatched[r - 'a'] >= 0) {
                if (++matched == p.length()) {
                    ret.add(left);
                }
            }
            ++right;
            while (right - left == p.length()) {
                if (++unmatched[s.charAt(left++) - 'a'] > 0) {
                    matched--;
                }
            }

        }
        return ret;
    }

    @Test
    public void test() {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("baa", "aa"));

    }
}
