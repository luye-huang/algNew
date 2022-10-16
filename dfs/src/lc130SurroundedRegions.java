import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.HashMap;

public class lc130SurroundedRegions {
    HashMap<String, Boolean> visiting = new HashMap<>();
    HashMap<String, Boolean> visited = new HashMap<>();

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    boolean notClosure = dfs(i, j, board.length, board[0].length, board);
                    if (!notClosure) {
                        for (String key : visiting.keySet()) {
                            String[] str = key.split(",");
                            board[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 'X';
                        }
                    }
                    visiting = new HashMap<>();
                }
            }
        }

    }

    private boolean dfs(int x, int y, int height, int width, char[][] board) {
        if (x < 0 || x >= height || y < 0 || y >= width) {
            return true;
        }
        if (board[x][y] == 'X') {
            return false;
        } else {
            String key = x + "," + y;
            if (visited.containsKey(key)) {
                return false;
            } else {
                visited.put(key, true);
                visiting.put(key, true);
                boolean up = dfs(x - 1, y, height, width, board);
                boolean down = dfs(x + 1, y, height, width, board);
                boolean left = dfs(x, y - 1, height, width, board);
                boolean right = dfs(x, y + 1, height, width, board);
                return up || down || left || right;
            }
        }
    }

    @Test
    public void test() {
        char[][] data = new char[][]{
                {'O', 'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O'}};
        System.out.println();
        solve(data);
    }
}
