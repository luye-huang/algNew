import org.junit.Test;

import java.util.HashMap;

public class lc1020NumberofEnclaves {
    private int enclaves = 0;
    private int curEnclaves = 0;
    HashMap<String, Boolean> hashMap = new HashMap<>();

    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !dfs(i, j, grid)) {
                    enclaves += curEnclaves;
                }
                curEnclaves = 0;
            }
        }
        return enclaves;
    }

    private boolean dfs(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length) {
            return true;
        }
        if (y < 0 || y >= grid[0].length) {
            return true;
        }
        if (grid[x][y] == 0) {
            return false;
        }
        if (hashMap.containsKey(x + "-" + y)) {
            return false;
        }
        hashMap.put(x + "-" + y, false);
        boolean up = dfs(x - 1, y, grid);
        boolean down = dfs(x + 1, y, grid);
        boolean left = dfs(x, y - 1, grid);
        boolean right = dfs(x, y + 1, grid);
        boolean ret = up || down || left || right;
        hashMap.put(x + "-" + y, ret);
        curEnclaves++;
        return ret;
    }


//    反向操作
//    public int numEnclaves(int[][] A) {
//        int result = 0;
//        for(int i = 0; i < A.length; i++) {
//            for(int j = 0; j < A[i].length; j++) {
//                if(i == 0 || j == 0 || i == A.length - 1 || j == A[i].length - 1)
//                    dfs(A, i, j);
//            }
//        }
//
//        for(int i = 0; i < A.length; i++) {
//            for(int j = 0; j < A[i].length; j++) {
//                if(A[i][j] == 1)
//                    result++;
//            }
//        }
//
//        return result;
//    }
//
//    public void dfs(int a[][], int i, int j) {
//        if(i >= 0 && i <= a.length - 1 && j >= 0 && j <= a[i].length - 1 && a[i][j] == 1) {
//            a[i][j] = 0;
//            dfs(a, i + 1, j);
//            dfs(a, i - 1, j);
//            dfs(a, i, j + 1);
//            dfs(a, i, j - 1);
//        }
//    }

    @Test
    public void test() {
        System.out.println(numEnclaves(new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}));
        System.out.println();
    }
}
