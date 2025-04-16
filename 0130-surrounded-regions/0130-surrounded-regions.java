class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;

        for (int r = 0; r < board.length; r++) {
            checkCellAndMarkIfNecessary(board, r, 0);
            checkCellAndMarkIfNecessary(board, r, board[0].length - 1);
        }
        for (int c = 0; c < board[0].length; c++) {
            checkCellAndMarkIfNecessary(board, 0, c);
            checkCellAndMarkIfNecessary(board, board.length - 1, c);
        }

        markCapturedCellsAndUnmarkSafeCells(board);
    }

    /**
     * check whether 'O' is safe and mark it as '.' to change back in the future
     */
    private void checkCellAndMarkIfNecessary(char[][] board, int r, int c) {
        if (board[r][c] == 'X' || board[r][c] == '.') return;
        
        board[r][c] = '.';

        if (r > 0) checkCellAndMarkIfNecessary(board, r - 1, c);
        if (r < board.length - 1) checkCellAndMarkIfNecessary(board, r + 1, c);
        if (c > 0) checkCellAndMarkIfNecessary(board, r, c - 1);
        if (c < board[0].length - 1) checkCellAndMarkIfNecessary(board, r, c + 1);
    }

    /**
     * 'capture' unsafe 'X' cells by marking them as 'O', and
     * unmark safe cells from '.' back to 'O'
     */
    private void markCapturedCellsAndUnmarkSafeCells(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                else if (board[r][c] == '.') board[r][c] = 'O';
            }
        }
    }
}