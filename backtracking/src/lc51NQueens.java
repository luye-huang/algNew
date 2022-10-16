import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc51NQueens {
    List<List<String>> ret = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        backtrack(new ArrayList<Integer>(), 1, n);
        return ret;
    }

    private void backtrack(List<Integer> positions, int layer, int n) {
        if (positions.size() == n) {
            List<String> path = new ArrayList<>();
            for (Integer pos : positions) {
                char[] charArray = new char[n];
                Arrays.fill(charArray, '.');
                charArray[pos-1] = 'Q';
                path.add(new String(charArray));
            }
            ret.add(path);
        }
        for (int i = 1; i <= n; i++) {
            boolean conflict = false;
            for (int j = 1; j <= positions.size(); j++) {
                if (positions.get(j - 1) == i || layer - j == Math.abs(i - positions.get(j - 1))) {
                    conflict = true;
                    break;
                }
            }
            if (conflict) {
                continue;
            }
            positions.add(i);
            backtrack(positions, layer + 1, n);
            positions.remove(positions.size() - 1);
        }
    }

    @Test
    public void test() {
//        System.out.println(String.format("%1$-" + 12 + "s", "input  String").replace(' ', '*') + "");
//        System.out.println(String.format("%-" + 4 + "s", "").replace(' ', '*'));
        System.out.println(solveNQueens(4));
    }
}
