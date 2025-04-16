class Solution {
    public void solve(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            checkAndMarkIfNecessary(board, r, 0);
            checkAndMarkIfNecessary(board, r, board[0].length - 1);
        }
        for (int c = 0; c < board[0].length; c++) {
            checkAndMarkIfNecessary(board, 0, c);
            checkAndMarkIfNecessary(board, board.length - 1, c);
        }

        unmarkSafeCells(board);
    }

    /**
     * check whether 'O' is safe and mark it as '.' to change back in the future
     */
    private void checkAndMarkIfNecessary(char[][] board, int r, int c) {
        if (board[r][c] == 'X' || board[r][c] == '.') return;
        
        board[r][c] = '.';

        if (r > 0) checkAndMarkIfNecessary(board, r - 1, c);
        if (r < board.length - 1) checkAndMarkIfNecessary(board, r + 1, c);
        if (c > 0) checkAndMarkIfNecessary(board, r, c - 1);
        if (c < board[0].length - 1) checkAndMarkIfNecessary(board, r, c + 1);
    }

    /**
     * unmark safe cells from '.' back to 'O'
     */
    private void unmarkSafeCells(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                else if (board[r][c] == '.') board[r][c] = 'O';
            }
        }
    }
}