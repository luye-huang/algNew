import org.junit.Test;

public class MergeSort {
    public static void mergeSort(int[] nums, int left, int right) {
        if (right - left < 1) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        int[] ret = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            ret[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        if (i <= mid) {
            while (k < ret.length) {
                ret[k++] = nums[i++];
            }
        } else if (j <= right) {
            while (k < ret.length) {
                ret[k++] = nums[j++];
            }
        }
        for (i = 0; i < ret.length; i++) {
            nums[left++] = ret[i];
        }
    }

    @Test
    public void test() {
        int nums[] = new int[]{6, 5, 18, 7, 3, 11};
        mergeSort(nums, 0, 5);
        System.out.println(nums);
    }
}
