import org.junit.Test;

public class lc79WordSearch {

    public boolean exist(char[][] board, String word) {
        boolean[][] visiting = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(i, j, board, word.toCharArray(), 0, visiting)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(int x, int y, char[][] board, char[] word, int index, boolean[][] visiting) {
        if (x < 0 || x >= board.length) {
            return false;
        }
        if (y < 0 || y >= board[0].length) {
            return false;
        }
        if (visiting[x][y]) {
            return false;
        }
        if (word[index] == board[x][y]) {
            if (index == word.length - 1) {
                return true;
            }
            visiting[x][y] = true;
            boolean adjacent = search(x, y - 1, board, word, index + 1, visiting) || search(x, y + 1, board, word, index + 1, visiting) || search(x - 1, y, board, word, index + 1, visiting) || search(x + 1, y, board, word, index + 1, visiting);
            visiting[x][y] = false;
            return adjacent;
        } else {
            return false;
        }
    }

    @Test
    public void test() {
//        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCESEEEFS"));

    }
}
