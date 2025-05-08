class Solution {
    private static final char MARK_O = 'O';
    private static final char MARK_X = 'X';
    private static final char MARK_TEMP = '.';
    private static final int[][] NEIGHBORS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void solve(char[][] board) {

        temporarilyMarkEdgeRegions(board);
        markCapturedRegionsAndUnmarkTemporarilyMarkedRegions(board);
    }

    private void temporarilyMarkEdgeRegions(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            temporarilyMarkRegion(board, r, 0);
            temporarilyMarkRegion(board, r, board[0].length - 1);
        }
        for (int c = 0; c < board[0].length; c++) {
            temporarilyMarkRegion(board, 0, c);
            temporarilyMarkRegion(board, board.length - 1, c);
        }
    }

    private void temporarilyMarkRegion(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;
        if (board[r][c] != MARK_O) return;

        board[r][c] = MARK_TEMP;
        for (int[] neighbor : NEIGHBORS) {
            temporarilyMarkRegion(board, r + neighbor[0], c + neighbor[1]);
        }
    }

    private void markCapturedRegionsAndUnmarkTemporarilyMarkedRegions(char[][] board) {
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