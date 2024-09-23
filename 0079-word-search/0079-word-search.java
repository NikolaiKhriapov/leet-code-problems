class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        if (word.length() > rows * cols) return false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (recursive(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean recursive(char[][] board, String word, int index, int r, int c) {
        if (index == word.length()) {
            return true;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        int[][] options = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        for (int[] option : options) {
            int rNew = r + option[0];
            int cNew = c + option[1];
            if (recursive(board, word, index + 1, rNew, cNew)) {
                return true;
            }
        }

        board[r][c] = temp;

        return false;
    }
}