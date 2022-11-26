import org.junit.Test;

import java.util.HashMap;

public class lc3LongestSubstringWithoutRepeatingCharacters {
    // ++i 比 i++块，后者需要多申请一个空间

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, lastOccurance = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                lastOccurance = Math.max(lastOccurance, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - lastOccurance + 1);
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println(lengthOfLongestSubstring("au"));
    }
}
