import org.junit.Test;

public class lc289GameofLife {
    public void gameOfLife(int[][] board) {
        int[][] countOne = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    if (i - 1 >= 0) {
                        if (j - 1 >= 0) {
                            countOne[i - 1][j - 1]++;
                        }
                        countOne[i - 1][j]++;
                        if (j + 1 < board[0].length) {
                            countOne[i - 1][j + 1]++;
                        }
                    }
                    if (j - 1 >= 0) {
                        countOne[i][j - 1]++;
                    }
                    if (j + 1 < board[0].length) {
                        countOne[i][j + 1]++;
                    }
                    if (i + 1 < board.length) {
                        if (j - 1 >= 0) {
                            countOne[i + 1][j - 1]++;
                        }
                        countOne[i + 1][j]++;
                        if (j + 1 < board[0].length) {
                            countOne[i + 1][j + 1]++;
                        }
                    }
                }

            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    if (countOne[i][j] < 2 || countOne[i][j] > 3) {
                        board[i][j] = 0;
                    }
                } else if (board[i][j] == 0) {
                    if (countOne[i][j] == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }

    @Test
    public void test() {
        int[][] arr = new int[][]{{1, 1}, {1, 0}};
        gameOfLife(arr);
    }
}
