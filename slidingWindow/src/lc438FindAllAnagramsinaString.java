import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class lc438FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new LinkedList<>();
        int[] unmatched = new int[26];      //每个字符需要匹配的个数
        int[] original = new int[26];
        int matched = 0;    //已匹配的字符个数，与t的长度比较
        for (int i = 0; i < p.length(); i++) {
            ++unmatched[p.charAt(i) - 'a'];
            ++original[p.charAt(i) - 'a'];
        }
        int left = 0, right = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            //有一个字符不在，收缩。新的left为right右面一个
            if (original[r - 'a'] == 0) {
                left = ++right;
                unmatched = original.clone();
                matched = 0;
                continue;
            }
            //在t里面的情况下，如果该字符还需要匹配，则判断是否符合结果，如果符合计入结果并left++，不符合right++
            //如果该字符已经不需要匹配，则要右移left到第一个等于right位置字符的位置，并维护unmatched matched
            if (--unmatched[r - 'a'] >= 0) {
                if (++matched == p.length()) {
                    ret.add(left);
                    unmatched[s.charAt(left++) - 'a']++;
                    matched--;
                }
            } else {
                while (s.charAt(left) != s.charAt(right)) {
                    unmatched[s.charAt(left++) - 'a']++;
                    matched--;
                }
                unmatched[s.charAt(left++) - 'a']++;
            }
            right++;
        }
        return ret;
    }

    @Test
    public void test() {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
//        System.out.println(findAnagrams("baa", "aa"));
    }
}
