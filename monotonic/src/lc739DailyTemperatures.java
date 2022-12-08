import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc739DailyTemperatures {
    //比后面小的温度都处理掉，因此留下的是一个递增队列
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ret = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty()) {
                int temp = deque.pollLast();
                if (temperatures[temp] < temperatures[i]) {
                    ret[temp] = i - temp;
                } else {
                    deque.add(temp);
                    break;
                }
            }
            deque.add(i);
        }
        return ret;
    }


    @Test
    public void test() {
        int[] arr = dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        System.out.println();
    }
}
