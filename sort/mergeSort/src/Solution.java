import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//self-practive for 315
public class Solution {
    int[] smallCnt;

    private class ValueWithIndex {
        public int value;
        public int index;

        public ValueWithIndex(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        smallCnt = new int[nums.length];
        ValueWithIndex[] array2Sort = new ValueWithIndex[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array2Sort[i] = new ValueWithIndex(nums[i], i);
        }
        mergeSort(array2Sort, 0, nums.length - 1);
        List<Integer> list = new ArrayList<>(nums.length);
        for (int cnt : smallCnt) {
            list.add(cnt);
        }
        return list;
    }

    private void mergeSort(ValueWithIndex[] list, int left, int right) {
        if (right <= left) return;
        int mid = left + (right - left) / 2;
        mergeSort(list, left, mid);
        mergeSort(list, mid + 1, right);
        merge(list, left, mid, right);
    }

    private void merge(ValueWithIndex[] arr, int left, int mid, int right) {
        int startA = left, startB = mid + 1;
        int needToAddAsBiggerValue = 0;
        List<ValueWithIndex> tmpSortingList = new LinkedList<>();
        while (startA <= mid && startB <= right) {
            if (arr[startA].value <= arr[startB].value) {
                smallCnt[arr[startA].index] += needToAddAsBiggerValue;
                tmpSortingList.add(arr[startA++]);
            } else {
                needToAddAsBiggerValue++;
                tmpSortingList.add(arr[startB++]);
            }
        }
        while (startA <= mid) {
            smallCnt[arr[startA].index] += needToAddAsBiggerValue;
            tmpSortingList.add(arr[startA++]);
        }
        while (startB <= right) {
            tmpSortingList.add(arr[startB++]);
        }
        for (ValueWithIndex el : tmpSortingList) {
            arr[left++] = el;
        }
    }

    @Test
    public void test() {
        System.out.println(countSmaller(new int[]{5, 2, 6, 1}));
    }
}
