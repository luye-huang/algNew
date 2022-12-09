import org.junit.Test;
import java.util.*;
import java.util.stream.Collectors;

//与56题极其接近，对每个interval的左界先排序，然后合并interval
public class lc763PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> left = new HashMap<>();
        HashMap<Character, Integer> right = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!left.containsKey(c)) {
                left.put(c, i);
            }
            right.put(c, i);
        }
        List<Map.Entry<Character, Integer>> list = left.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).collect(Collectors.toList());
        List<Integer> ret = new LinkedList<>();
        int intervalLeft = list.get(0).getValue(), intervalRight = right.get(list.get(0).getKey());
        for (int i = 1; i < list.size(); i++) {
            int curIntervalLeft = list.get(i).getValue();
            int curIntervalRight = right.get(list.get(i).getKey());
            if (intervalRight >= curIntervalLeft) {
                intervalRight = Math.max(intervalRight, curIntervalRight);
            } else {
                ret.add(intervalRight - intervalLeft + 1);
                intervalLeft = curIntervalLeft;
                intervalRight = curIntervalRight;
            }
        }
        ret.add(intervalRight - intervalLeft + 1);
        return ret;
    }

    @Test
    public void test() {
        System.out.println(partitionLabels("eccbbbbdec"));

    }
}
