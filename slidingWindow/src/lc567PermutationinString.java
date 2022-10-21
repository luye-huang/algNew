import org.testng.annotations.Test;

import java.util.HashMap;

public class lc567PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0;
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); ++i) {
            char key = s1.charAt(i);
            if (need.containsKey(key)) {
                need.put(key, need.get(key) + 1);
            } else {
                need.put(key, 1);
                window.put(key, 0);
            }
        }
        int valid = 0;
        while (right < s2.length()) {
            char r = s2.charAt(right++);
            if (window.containsKey(r)) {
                int val = window.get(r) + 1;
                if (val == need.get(r)) {
                    ++valid;
                    if (valid == need.keySet().size()) {
                        return true;
                    }
                }
                window.put(r, val);
            } else {
                left = right;
                valid = 0;
                window.replaceAll((k, v) -> 0);
            }
            while (right - left >= s1.length()) {
                char l = s2.charAt(left++);
                if (need.containsKey(l)) {
                    int val = window.get(l) - 1;
                    if (val == need.get(l) - 1) {
                        valid--;
                    }
                    window.put(l, val);
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
//        System.out.println(checkInclusion("ab", "eidbaooo"));
//        System.out.println(checkInclusion("ab", "eidboaoo"));
        System.out.println(checkInclusion("adc", "dcda"));
    }
}
