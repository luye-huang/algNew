import org.junit.Test;

import java.util.*;

public class lc315CountofSmallerNumbersAfterSelf {
    // Wrapper class for each and every value of the input array,
    // to store the original index position of each value, before we merge sort the array
    private class ArrayValWithOrigIdx {
        int val;
        int originalIdx;

        public ArrayValWithOrigIdx(int val, int originalIdx) {
            this.val = val;
            this.originalIdx = originalIdx;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new LinkedList<Integer>();
        int n = nums.length;
        int[] result = new int[n];

        ArrayValWithOrigIdx[] newNums = new ArrayValWithOrigIdx[n];
        for (int i = 0; i < n; ++i) newNums[i] = new ArrayValWithOrigIdx(nums[i], i);

        mergeSortAndCount(newNums, 0, n - 1, result);

        // notice we don't care about the sorted array after merge sort finishes.
        // we only wanted the result counts, generated by running merge sort
        List<Integer> resultList = new LinkedList<Integer>();
        for (int i : result) resultList.add(i);
        return resultList;
    }

    private void mergeSortAndCount(ArrayValWithOrigIdx[] nums, int start, int end, int[] result) {
        if (start >= end) return;

        int mid = (start + end) / 2;
        mergeSortAndCount(nums, start, mid, result);
        mergeSortAndCount(nums, mid + 1, end, result);

        // left subarray start...mid
        // right subarray mid+1...end
        int leftPos = start;
        int rightPos = mid + 1;
        LinkedList<ArrayValWithOrigIdx> merged = new LinkedList<ArrayValWithOrigIdx>();
        int numElemsRightArrayLessThanLeftArray = 0;
        while (leftPos < mid + 1 && rightPos <= end) {
            if (nums[leftPos].val > nums[rightPos].val) {
                // this code block is exactly what the problem is asking us for:
                // a number from the right side of the original input array, is smaller
                // than a number from the left side
                //
                // within this code block,
                // nums[rightPos] is smaller than the start of the left sub-array.
                // Since left sub-array is already sorted,
                // nums[rightPos] must also be smaller than the entire remaining left sub-array
                ++numElemsRightArrayLessThanLeftArray;

                // continue with normal merge sort, merge
                merged.add(nums[rightPos]);
                ++rightPos;
            } else {
                // a number from left side of array, is smaller than a number from
                // right side of array
                result[nums[leftPos].originalIdx] += numElemsRightArrayLessThanLeftArray;

                // Continue with normal merge sort
                merged.add(nums[leftPos]);
                ++leftPos;
            }
        }

        // part of normal merge sort, if either left or right sub-array is not empty,
        // move all remaining elements into merged result
        while (leftPos < mid + 1) {
            result[nums[leftPos].originalIdx] += numElemsRightArrayLessThanLeftArray;

            merged.add(nums[leftPos]);
            ++leftPos;
        }
        while (rightPos <= end) {
            merged.add(nums[rightPos]);
            ++rightPos;
        }

        // part of normal merge sort
        // copy back merged result into array
        int pos = start;
        for (ArrayValWithOrigIdx m : merged) {
            nums[pos] = m;
            ++pos;
        }
    }

    @Test
    public void test() {
        System.out.println(countSmaller(new int[]{5, 2, 6, 1}));

    }
}
