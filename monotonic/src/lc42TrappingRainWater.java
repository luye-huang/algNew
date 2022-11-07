import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc42TrappingRainWater {
    public int trap(int[] height) {
        int ret = 0;
        //monotonic less
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            int bottom = deque.isEmpty() ? 0 : height[deque.peekLast()];
            while (!deque.isEmpty() && height[deque.peekLast()] <= height[i]) {
                int num = deque.pollLast();
                ret += (height[num] - bottom) * (i - num - 1);
                bottom = height[num];
            }
            if (!deque.isEmpty()) {
                ret += (height[i] - bottom) * (i - deque.peekLast() - 1);
            }
            deque.offer(i);
        }
        return ret;
    }

    @Test
    public void test() {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{2, 0, 2}));

        System.out.println();
    }
}
