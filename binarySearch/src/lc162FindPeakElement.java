import org.testng.annotations.Test;

public class lc162FindPeakElement {

    //  https://leetcode.com/problems/find-peak-element/discuss/1290642/Intuition-behind-conditions-or-Complete-Explanation-or-Diagram-or-Binary-Search
    // 二分index找一个mid跟两边邻居比，可以有三种情况：1 比两边都大，返回mid 2 比左小，缩范围到左边 3比右下，缩范围到右边
    //
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0; // single element
        int n = nums.length;
        // check if 0th/n-1th index is the peak element
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int left = 1, right = n - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] <= nums[mid - 1]) {
                right = mid - 1;
            } else if (nums[mid] <= nums[mid + 1]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));

    }
}
