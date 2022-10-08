import org.junit.Test;

import java.util.HashMap;

public class lc3LongestSubstringWithoutRepeatingCharacters {
    // ++i 比 i++块，后者需要多申请一个空间


//    public int lengthOfLongestSubstring(String s) {
//        if (s.length() < 2) {
//            return s.length();
//        }
//        int ret = 0, i = 0, j = 1;
//        HashMap<Character, Integer> hashMap = new HashMap<>();
//        hashMap.put(s.charAt(i), 0);
//        while (j < s.length()) {
//            if (hashMap.containsKey(s.charAt(j))) {
//                ret = Math.max(ret, j - i);
//                i = hashMap.get(s.charAt(j)) + 1;
//                j = i + 1;
//                if (i < s.length()) {
//                    hashMap = new HashMap<>();
//                    hashMap.put(s.charAt(i), i);
//                }
//            } else {
//                hashMap.put(s.charAt(j), j);
//                j++;
//            }
//        }
//        return Math.max(ret, s.length()  - i);
//    }


    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    @Test
    public void test() {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("au"));
    }
}
