class Solution {
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        return helper(new boolean[n][n], 0);
    }

    private int helper(boolean[][] board, int row) {
        if (row == board.length) {
            return 1;
        }

        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += helper(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private boolean isSafe(boolean[][] board, int row, int col) {
        for (int r = 0; r < row; r++) {
            if (board[r][col]) return false;
        }
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c]) return false;
        }
        for (int r = row - 1, c = col + 1; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c]) return false;
        }
        return true;
    }
}