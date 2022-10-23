import org.testng.annotations.Test;

import java.util.Arrays;

public class lc567PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0;
        int[] need = new int[26];
        int[] window = new int[26];
        int match = 0, unmatched = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (need[s1.charAt(i) - 'a'] == 0) {
                match++;
            }
            need[s1.charAt(i) - 'a']++;
        }
        unmatched = match;
        while (right < s2.length()) {
            char r = s2.charAt(right++);
            if (need[r - 'a'] == 0) {
                left = right;
//                Arrays.fill(window, 0);
//                window = empty.clone();
                // Array.fill 和 clone都比new新的数组慢
                window = new int[26];
                unmatched = match;
                continue;
            }
            if (++window[r - 'a'] == need[r - 'a']) {
                if (--unmatched == 0) {
                    return true;
                }
            }
            while (right - left >= s1.length()) {
                char l = s2.charAt(left++);
                if (window[l - 'a']-- == need[l - 'a']) {
                    ++unmatched;
                }
            }
        }
        return false;
    }


    //最好解法
//    public boolean checkInclusion(String s1, String s2) {
//        int[] count = new int[26];
//        for (int i = 0; i < s1.length(); i++) {
//            count[s1.charAt(i) - 'a']++;
//        }
//        int left = 0, right = 0, unmatched = s1.length();
//        while (right < s2.length()) {
//            if (count[s2.charAt(right++) - 'a']-- >= 1) {
//                unmatched--;
//            }
//            if (unmatched == 0) return true;
//            if (right - left == s1.length() && count[s2.charAt(left++) - 'a']++ >= 0) {
//                unmatched++;
//            }
//        }
//        return false;
//    }

    @Test
    public void test() {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
        System.out.println(checkInclusion("adc", "dcda"));
        System.out.println(checkInclusion("abcdxabcde", "abcdabcdex"));


        System.out.println(checkInclusion("trinitrophenylmethylnitramine", "dinitrophenylhydrazinetrinitrophenylmethylnitramine"));
    }
}
