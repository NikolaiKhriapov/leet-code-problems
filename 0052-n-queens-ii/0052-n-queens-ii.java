class Solution {
    public int totalNQueens(int n) {
        
        boolean[][] board = new boolean[n][n];
        int[] count = new int[]{0};
        helper(board, n, 0, count);
        return count[0];
    }

    private void helper(boolean[][] board, int n, int row, int[] count) {
        if (row == n) {
            count[0]++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, n, row, col)) {
                board[row][col] = true;
                helper(board, n, row + 1, count);
                board[row][col] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int n, int row, int col) {
        for (int r = 0; r < row; r++) {
            if (board[r][col]) return false;
        }

        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c]) return false;
        }

        for (int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++) {
            if (board[r][c]) return false;
        }

        return true;
    }
}