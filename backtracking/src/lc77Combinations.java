import java.util.ArrayList;
import java.util.List;

public class lc77Combinations {
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new ArrayList<>());
        return ret;
    }

    private void backtrack(int num, int max, int len, List<Integer> combination) {
        if (combination.size() == len) {
            ret.add(new ArrayList<>(combination));
            return;
        }
        //前面如果选的太少，导致后面即使都选也不够，就提前退出
        if (max - num + combination.size() + 1 < len) {
            return;
        }
        backtrack(num + 1, max, len, combination);
        combination.add(num);
        backtrack(num + 1, max, len, combination);
        combination.remove(combination.size() - 1);
    }
}
