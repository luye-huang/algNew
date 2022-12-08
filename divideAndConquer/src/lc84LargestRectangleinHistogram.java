import org.junit.Test;

public class lc84LargestRectangleinHistogram {
    //https://leetcode.com/problems/largest-rectangle-in-histogram/solutions/2890526/o-n-java-solution-super-fast-and-understandable/
    //From a perspective of Divide and Conquer, the value we seek is the max of values of using each element as the lowest limit.
    //Hence, we need to pinpoint left boundary and right boundary for each element. This pair of boundaries have to meet 2 conditions: 1 The height has to be bigger than the element. 2 The range betweent the left and right has to be widest. In another word, left boundary has to be leftest, right has to be rightest. I do 2 loop to find them.
    public int largestRectangleArea(int[] heights) {
        int ret = 0;
        int[] earliestIndexWithBiggerValue = new int[heights.length];
        int[] latestIndexWithBiggerValue = new int[heights.length];
        //从左边确定earliestIndexWithBiggerValue
        for (int i = 0; i < heights.length; i++) {
            int left = i - 1;
            while (left >= 0) {
                if (heights[left] >= heights[i]) {
                    left = earliestIndexWithBiggerValue[left] - 1;
                } else {
                    break;
                }
            }
            earliestIndexWithBiggerValue[i] = ++left;
        }

        //从右边确定latestIndexWithBiggerValue
        for (int i = heights.length - 1; i >= 0; i--) {
            int right = i + 1;
            while (right < heights.length) {
                if (heights[right] >= heights[i]) {
                    right = latestIndexWithBiggerValue[right] + 1;
                } else {
                    break;
                }
            }
            latestIndexWithBiggerValue[i] = --right;
        }
        for (int i = 0; i < heights.length; i++) {
            ret = Math.max(ret, (latestIndexWithBiggerValue[i] - earliestIndexWithBiggerValue[i] + 1) * heights[i]);
        }
        return ret;
    }

    @Test
    public void test() {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleArea(new int[]{2, 1, 2}));

    }
}
