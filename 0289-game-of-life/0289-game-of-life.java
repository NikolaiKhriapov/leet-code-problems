class Solution {
    private static final int DEAD = 0;
    private static final int LIVE = 1;
    private static final int DEAD_TO_LIVE = 11;
    private static final int LIVE_TO_DEAD = 10;
    private static final int[][] NEIGHBORS = new int[][] { {1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1} };

    public void gameOfLife(int[][] board) {
        if (board == null) {
            throw new IllegalArgumentException("Invalid state"); // for simplicity
        }
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        markBoardForNextState(board);
        updateBoardToNextState(board);
    }

    private void markBoardForNextState(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int neighborsCount = countLiveNeighbours(board, row, col);
                if (board[row][col] == LIVE && (neighborsCount < 2 || neighborsCount > 3)) {
                    board[row][col] = LIVE_TO_DEAD;
                }
                if (board[row][col] == DEAD && neighborsCount == 3) {
                    board[row][col] = DEAD_TO_LIVE;
                }
            }
        }
    }

    private void updateBoardToNextState(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == LIVE_TO_DEAD) {
                    board[row][col] = DEAD;
                }
                if (board[row][col] == DEAD_TO_LIVE) {
                    board[row][col] = LIVE;
                }
            }
        }
    }

    private int countLiveNeighbours(int[][] board, int row, int col) {
        int count = 0;
        for (int[] neighbor : NEIGHBORS) {
            int neighborRow = row + neighbor[0];
            int neighborCol = col + neighbor[1];
            if (neighborRow < 0 || neighborRow >= board.length || neighborCol < 0 || neighborCol >= board[0].length) {
                continue;
            }
            if (board[neighborRow][neighborCol] == LIVE || board[neighborRow][neighborCol] == LIVE_TO_DEAD) {
                count++;
            }
        }
        return count;
    }
}