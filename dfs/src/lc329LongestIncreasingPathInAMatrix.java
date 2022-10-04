import org.junit.Test;

public class lc329LongestIncreasingPathInAMatrix {
    int[][] cache;

    public int longestIncreasingPath(int[][] matrix) {
        int height = matrix.length, width = matrix[0].length;
        int ret = 0;
        cache = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // 减一是为了区分是开始dfs还是由前面的点进入
                ret = Math.max(ret, dfs(matrix, cache, matrix[i][j] - 1, i, j, height, width));
            }
        }
        return ret;
    }

    private int dfs(int[][] matrix, int[][] cache, int val, int x, int y, int height, int width) {
        int ret = 0;
//        int height = matrix.length;
//        int width = matrix[0].length;
        if (x < 0 || x >= height || y < 0 || y >= width) {
            return 0;
        }
        if (val >= matrix[x][y]) {
            return 0;
        }
        if (cache[x][y] > 0) {
            return cache[x][y];
        } else {
            int left = dfs(matrix, cache, matrix[x][y], x - 1, y, height, width) + 1;
            int right = dfs(matrix, cache, matrix[x][y], x + 1, y, height, width) + 1;
            int up = dfs(matrix, cache, matrix[x][y], x, y - 1, height, width) + 1;
            int down = dfs(matrix, cache, matrix[x][y], x, y + 1, height, width) + 1;
            ret = Math.max(ret, left);
            ret = Math.max(ret, right);
            ret = Math.max(ret, up);
            ret = Math.max(ret, down);
            cache[x][y] = ret;
        }
        return ret;
    }

    @Test
    public void test() {
        System.out.println(longestIncreasingPath(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}));
        System.out.println(longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
        System.out.println(longestIncreasingPath(new int[][]{{2147483647, 1}}));
    }
}
