import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class lc76MinimumWindowSubstring {
    //labuladong p87
    //吻合的字符等于t的长度时收缩，未到时扩展
    //用unmatched记录每个字符吻合的次数，可以为负
    //用contained记录没个字符是否包含，如果包含，作为窗口每次收缩左界的取值，用一个queue维护
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
            //字符匹配不上，扩展窗口
            if (contained[r - 'A'] == 0) {
                ++right;
                continue;
            }
            queue.add(right);
            //字符匹配上但该字符已经完全匹配，扩展窗口，并记录这个index用于后面收缩
            if (--unmatched[r - 'A'] >= 0) {
                //t中的每个已经全部匹配，开始收缩
                if (++matched == t.length()) {
                    while (!queue.isEmpty()) {
                        left = queue.poll();
                        //有一个字符因收缩而导致不是每个字符都匹配，停止收缩
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
//        queue.add(20);
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
        System.out.println(minWindow("EEADOBECODEBANC", "ABC"));

    }
}
