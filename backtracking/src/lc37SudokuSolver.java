import org.junit.Test;

public class lc37SudokuSolver {
    boolean done = false;

    public void solveSudoku(char[][] board) {
        backtrack(0, 0, board);
    }

    private void backtrack(int x, int y, char[][] board) {
        if (x > 8) {
            done = true;
            return;
        }
        if (board[x][y] != '.') {
            if (y == 8) {
                backtrack(x + 1, 0, board);
            } else {
                backtrack(x, y + 1, board);
            }
            return;
        }
        for (char i = '1'; i <= '9'; i++) {
            if (isValid(i, x, y, board)) {
                board[x][y] = i;
                if (y == 8) {
                    backtrack(x + 1, 0, board);
                } else {
                    backtrack(x, y + 1, board);
                }
                if (done) {
                    return;
                }
                board[x][y] = '.';
            }
        }
    }

    private boolean isValid(char ch, int x, int y, char[][] board) {
        for (int i = 0; i < x; i++) {
            if (board[i][y] == ch) {
                return false;
            }
        }
        for (int i = x + 1; i < 9; i++) {
            if (board[i][y] == ch) {
                return false;
            }
        }
        for (int i = 0; i < y; i++) {
            if (board[x][i] == ch) {
                return false;
            }
        }
        for (int i = y + 1; i < 9; i++) {
            if (board[x][i] == ch) {
                return false;
            }
        }
        int xStart = (x / 3) * 3, xFinal = xStart + 2;
        int yStart = (y / 3) * 3, yFinal = yStart + 2;
        while (xStart <= xFinal) {
            if (ch == board[xStart][yStart] && (xStart != x || yStart != y)) {
                return false;
            }
            if (yStart == yFinal) {
                yStart = yFinal - 2;
                ++xStart;
            } else {
                ++yStart;
            }
        }
        return true;
    }

    @Test
    public void test() {
        char[][] matrix = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        for (char i = '1'; i < '9'; i++) {
            System.out.println(i);
        }
        solveSudoku(matrix);
        System.out.println();
        System.out.println();
    }
}
