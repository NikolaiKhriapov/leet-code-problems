class Solution {
    private static final char MARK_O = 'O';
    private static final char MARK_X = 'X';
    private static final char MARK_TEMP = '.';

    public void solve(char[][] board) {
        if (board == null) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        markEdgeRegions(board);
        captureSurroundedAndUnmarkSafeRegions(board);
    }

    private void markEdgeRegions(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            markEdgeRegion(board, r, 0);
            markEdgeRegion(board, r, board[0].length - 1);
        }
        for (int c = 0; c < board[0].length; c++) {
            markEdgeRegion(board, 0, c);
            markEdgeRegion(board, board.length - 1, c);
        }
    }

    private void markEdgeRegion(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != MARK_O) {
            return;
        }

        board[r][c] = MARK_TEMP;

        markEdgeRegion(board, r + 1, c);
        markEdgeRegion(board, r, c + 1);
        markEdgeRegion(board, r - 1, c);
        markEdgeRegion(board, r, c - 1);
    }

    private void captureSurroundedAndUnmarkSafeRegions(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == MARK_O) {
                    board[r][c] = MARK_X;
                } else if (board[r][c] == MARK_TEMP) {
                    board[r][c] = MARK_O;
                }
            }
        }
    }
}