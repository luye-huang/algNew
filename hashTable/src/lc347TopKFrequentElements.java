import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class lc347TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ret = new int[k];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        //统计出现次数
        for (int num : nums) {
            int val = hashMap.getOrDefault(num, 0);
            hashMap.put(num, val + 1);
        }
        //按出现次数排序
        List<Map.Entry<Integer, Integer>> list = hashMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            ret[i] = list.get(i).getKey();
        }
        return ret;
    }

    @Test
    public void test() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 2);
        Integer[] arr = hashMap.values().toArray(new Integer[0]);
        System.out.println(arr[0]);

        System.out.println(topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 3, 3, 3, 3}, 2));

    }
}
