class Solution {
    private static final int LIVE = 1;
    private static final int DEAD = 0;
    private static final int LIVE_TO_DEAD = 10;
    private static final int DEAD_TO_LIVE = 11;
    private static final int[][] NEIGHBORS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        temporarilyMarkNextState(board);
        markNextState(board);
    }

    private void temporarilyMarkNextState(int[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                int neighborsCount = countNeighbors(board, r, c);
                if (board[r][c] == LIVE) {
                    if (neighborsCount < 2 || neighborsCount > 3) {
                        board[r][c] = LIVE_TO_DEAD;
                    }
                } else if (board[r][c] == DEAD) {
                    if (neighborsCount == 3) {
                        board[r][c] = DEAD_TO_LIVE;
                    }
                }
            }
        }
    }

    private void markNextState(int[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == LIVE_TO_DEAD) {
                    board[r][c] = DEAD;
                } else if (board[r][c] == DEAD_TO_LIVE) {
                    board[r][c] = LIVE;
                }
            }
        }
    }

    private int countNeighbors(int[][] board, int r, int c) {
        int neighborsCount = 0;
        for (int[] neighbor : NEIGHBORS) {
            int row = r + neighbor[0];
            int col = c + neighbor[1];
            if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && (board[row][col] == LIVE || board[row][col] == LIVE_TO_DEAD)) {
                neighborsCount++;
            }
        }
        return neighborsCount;
    }
}

// time  - O(n * m)
// space - O(1)