class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }

        boolean[][] board = new boolean[n][n];
        helper(board, n, 0);
        return count;
    }

    private void helper(boolean[][] board, int n, int row) {
        if (row == n) {
            count++;
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                helper(board, n, row + 1);
                board[row][col] = false;
            }
        }
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