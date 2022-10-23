import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class lc76MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] unmatched = new int[58];
        int[] contained = new int[58];
        Queue<Integer> queue = new LinkedList<>();
        int matched = 0;
        String ret = "";
        for (int i = 0; i < t.length(); i++) {
            unmatched[t.charAt(i) - 'A']++;
            contained[t.charAt(i) - 'A']++;
        }
        int left = 0, right = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            if (contained[r - 'A'] == 0) {
                ++right;
                continue;
            }
            queue.add(right);
            if (--unmatched[r - 'A'] >= 0) {
                if (++matched == t.length()) {
                    while (!queue.isEmpty()) {
                        left = queue.poll();
                        if (++unmatched[s.charAt(left) - 'A'] > 0) {
                            matched--;
                            break;
                        }
                    }
                    if (right - left < ret.length() || ret.length() == 0) {
                        ret = s.substring(left, right + 1);
                    }
                }
            }
            ++right;
        }
        return ret;
    }

    @Test
    public void test() {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(5);
//        queue.add(15);
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
        System.out.println(minWindow("EEADOBECODEBANC", "ABC"));

    }
}
