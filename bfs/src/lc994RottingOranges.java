import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class lc994RottingOranges {
//    public int orangesRotting(int[][] grid) {
//        int oranges = 0;
//        int goBad = 0;
//        int mins = -1;
//        boolean[][] visited = new boolean[grid.length][grid[0].length];
//        HashSet<int[]> rottens = new HashSet<>();
//        HashSet<int[]> tmp = new HashSet<>();
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 2) {
//                    rottens.add(new int[]{i, j});
//                    visited[i][j] = true;
//                } else if (grid[i][j] == 1) {
//                    oranges++;
//                } else {
//                    visited[i][j] = true;
//                }
//            }
//        }
//        if (oranges == 0) {
//            return 0;
//        }
//        while (!rottens.isEmpty()) {
//            mins++;
//            for (int[] cell : rottens) {
//                int x = cell[0], y = cell[1];
//                if (x - 1 >= 0 && !visited[x - 1][y]) {
//                    visited[x - 1][y] = true;
//                    tmp.add(new int[]{x - 1, y});
//                    goBad++;
//                }
//                if (y - 1 >= 0 && !visited[x][y - 1]) {
//                    visited[x][y - 1] = true;
//                    tmp.add(new int[]{x, y - 1});
//                    goBad++;
//                }
//                if (x + 1 < grid.length && !visited[x + 1][y]) {
//                    visited[x + 1][y] = true;
//                    tmp.add(new int[]{x + 1, y});
//                    goBad++;
//                }
//                if (y + 1 < grid[0].length && !visited[x][y + 1]) {
//                    visited[x][y + 1] = true;
//                    tmp.add(new int[]{x, y + 1});
//                    goBad++;
//                }
//            }
//            rottens.clear();
//            rottens.addAll(tmp);
//            tmp.clear();
//        }
//        return goBad >= oranges ? mins : -1;
//    }


    //counting elements of one queue instead of using 2 hashsets
    public int orangesRotting(int[][] grid) {
        int oranges = 0;
        int goBad = 0;
        int mins = -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> rottens = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rottens.add(new int[]{i, j});
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    oranges++;
                } else {
                    visited[i][j] = true;
                }
            }
        }
        if (oranges == 0) {
            return 0;
        }
        while (!rottens.isEmpty()) {
            //标记一轮的个数，每轮需要增加一个标记数
            int size = rottens.size();
            mins++;
            while (size >= 0) {
                int[] cell = rottens.poll();
                int x = cell[0], y = cell[1];
                size--;
                if (x - 1 >= 0 && !visited[x - 1][y]) {
                    visited[x - 1][y] = true;
                    rottens.add(new int[]{x - 1, y});
                    goBad++;
                }
                if (y - 1 >= 0 && !visited[x][y - 1]) {
                    visited[x][y - 1] = true;
                    rottens.add(new int[]{x, y - 1});
                    goBad++;
                }
                if (x + 1 < grid.length && !visited[x + 1][y]) {
                    visited[x + 1][y] = true;
                    rottens.add(new int[]{x + 1, y});
                    goBad++;
                }
                if (y + 1 < grid[0].length && !visited[x][y + 1]) {
                    visited[x][y + 1] = true;
                    rottens.add(new int[]{x, y + 1});
                    goBad++;
                }
            }
        }
        return goBad >= oranges ? mins : -1;
    }
}
