import org.testng.annotations.Test;

public class lc33SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] <= nums[right]) {
                break;
            }
            int mid = left + (right - left) / 2;
            if (mid == left) {
                left = nums[right] > nums[left] ? left : right;
                break;
            } else if (nums[mid] < nums[left]) {
                right = mid;
            } else if (nums[mid] > nums[left]) {
                left = mid + 1;
            }
        }
        int minIndex = left;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = nums[getSafeIndex(mid, nums.length, minIndex)];
            if (val == target) {
                return getSafeIndex(mid, nums.length, minIndex);
            } else if (val < target) {
                left = mid + 1;
            } else if (val > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int getSafeIndex(int i, int len, int offset) {
        return i + offset >= len ? i + offset - len : i + offset;
    }

    @Test
    public void test() {
//        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(search(new int[]{5, 1, 2}, 5));

    }
}
