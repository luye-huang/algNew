import org.junit.Test;

public class lc567PermutationinString {

    //同438
    public boolean checkInclusion(String s, String p) {
        int[] unmatched = new int[26];
        int[] original = new int[26];
        int matched = 0;
        for (int i = 0; i < s.length(); i++) {
            ++unmatched[s.charAt(i) - 'a'];
            ++original[s.charAt(i) - 'a'];
        }
        int left = 0, right = 0;
        while (right < p.length()) {
            char r = p.charAt(right);
            if (original[r - 'a'] == 0) {
                left = ++right;
                if (matched > 0) {
                    unmatched = original.clone();
                    matched = 0;
                }
                continue;
            }
            if (--unmatched[r - 'a'] >= 0) {
                if (++matched == s.length()) {
                    return true;
                }
            } else {
                while (p.charAt(left) != p.charAt(right)) {
                    unmatched[p.charAt(left++) - 'a']++;
                    matched--;
                }
                unmatched[p.charAt(left++) - 'a']++;
            }
            right++;
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
