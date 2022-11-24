import org.junit.Test;

import java.util.*;

public class lc239SlidingWindowMaximum {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int len = nums.length;
//        int[] ret = new int[len - k + 1];
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < k; i++) {
//            boolean added = false;
//            for (int j = 0; j < list.size(); j++) {
//                if (nums[i] > nums[list.get(j)]) {
//                    list.add(j, i);
//                    added = true;
//                    break;
//                }
//            }
//            if (!added) {
//                list.add(i);
//            }
//        }
////        ret[0] = nums[list.get(0)];
//        for (int i = 0; i + k < len; ++i) {
//            ret[i] = nums[list.get(0)];
//            boolean removed = false, added = false;
//            for (int j = 0; j < list.size() && (!removed || !added); j++) {
//                if (!removed && i == list.get(j)) {
//                    list.remove(j--);
//                    removed = true;
//                    continue;
//                }
//                if (!added && nums[i + k] > nums[list.get(j)]) {
//                    added = true;
//                    list.add(j, i + k);
//                }
//            }
//            if (!added) {
//                list.add(i + k);
//            }
//        }
//        ret[ret.length - 1] = nums[list.get(0)];
//        return ret;
//    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length - k < 0) {
            return nums;
        }
        int[] ret = new int[nums.length - k + 1];
        int retIndex = 0;
        //only keep elements that are bigger and earlier than cur. first one is the biggest(monotonic)
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            //remove elements our of range from head
            while (!q.isEmpty() && q.peek() <= i - k) {
                q.poll();
            }
            //remove elements smaller than current one from tail
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            //add cur element
            q.offer(i);
            if (i >= k - 1) {
                ret[retIndex++] = nums[q.peek()];
            }
        }
        return ret;
    }

    @Test
    public void test() {
//        int[] ret = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        int[] ret = maxSlidingWindow(new int[]{9, 11}, 2);
        System.out.println(12);
//        int[] ret = maxSlidingWindow(new int[]{7, 2, 4}, 2);
//        int[] ret = maxSlidingWindow(new int[]{1}, 1);
        System.out.println(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
//
    }

    @Test
    public void testBasic() {
//        Queue<Integer> q = new LinkedList<>();
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(10);
        q.offer(2);
        q.offer(3);
        q.poll();
        q.remove();
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(11);
        stack.add(12);
        stack.push(122);
        stack.pop();
        System.out.println(stack.peek());
    }
}
