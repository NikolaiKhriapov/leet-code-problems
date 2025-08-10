class Solution {
    private static final char REGION = 'O';
    private static final char CAPTURED = 'X';
    private static final char TEMP = '.';
    private static final int[][] NEIGHBORS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        temporarilyMarkEdgeRegions(board);
        captureSurroundedRegionsAndUnmarkTemporarilyMarkedEdgeRegions(board);
    }

    private void temporarilyMarkEdgeRegions(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            temporarilyMarkEdgeRegion(board, r, 0);
            temporarilyMarkEdgeRegion(board, r, board[0].length - 1);
        }
        for (int c = 0; c < board[0].length; c++) {
            temporarilyMarkEdgeRegion(board, 0, c);
            temporarilyMarkEdgeRegion(board, board.length - 1, c);
        }
    }

    private void temporarilyMarkEdgeRegion(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != REGION) {
            return;
        }
        board[row][col] = TEMP;
        for (int[] neighbor : NEIGHBORS) {
            temporarilyMarkEdgeRegion(board, row + neighbor[0], col + neighbor[1]);
        }
    }

    private void captureSurroundedRegionsAndUnmarkTemporarilyMarkedEdgeRegions(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == REGION) {
                    board[r][c] = CAPTURED;
                } else if (board[r][c] == TEMP) {
                    board[r][c] = REGION;
                }
            }
        }
    }
}

// time  - O(n * m)
// space - O(m * n)