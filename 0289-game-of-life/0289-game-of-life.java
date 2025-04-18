/**
 * TEMP_0 - 1 that became 0 -> in the next iteration must be changed to 0;
 * TEMP_1 - 0 that became 1 -> in the next iteration must be changed to 1;
 */
class Solution {
    private static final int TEMP_0 = 10;
    private static final int TEMP_1 = 11;

    public void gameOfLife(int[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                markCell(board, r, c);
            }
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                unmarkCell(board, r, c);
            }
        }
    }

    /**
     * Temporarily mark cell as 10 or 11
     */
    private void markCell(int[][] board, int r, int c) {
        if (board[r][c] == 0) {
            int liveNeighbors = countLiveNeighbors(board, r, c);
            if (liveNeighbors == 3) {
                board[r][c] = TEMP_1;
            }
        } else if (board[r][c] == 1) {
            int liveNeighbors = countLiveNeighbors(board, r, c);
            if (liveNeighbors < 2 || liveNeighbors > 3) {
                board[r][c] = TEMP_0;
            }
        }
    }

    /**
     * Unmark temporarily marked cells back to 0 or 1
     */
    private void unmarkCell(int[][] board, int r, int c) {
        if (board[r][c] == TEMP_0) {
            board[r][c] = 0;
        } else if (board[r][c] == TEMP_1) {
            board[r][c] = 1;
        }
    }

    /**
     * Counts live neighbors (1 or TEMP_0)
     */
    private int countLiveNeighbors(int[][] board, int r, int c) {
        int count = 0;

        if (r - 1 >= 0 && (board[r - 1][c] == 1 || board[r - 1][c] == TEMP_0)) count++;
        if (r + 1 < board.length && (board[r + 1][c] == 1 || board[r + 1][c] == TEMP_0)) count++;
        if (c - 1 >= 0 && (board[r][c - 1] == 1 || board[r][c - 1] == TEMP_0)) count++;
        if (c + 1 < board[0].length && (board[r][c + 1] == 1 || board[r][c + 1] == TEMP_0)) count++;
        if (r - 1 >= 0 && c - 1 >= 0 && (board[r - 1][c - 1] == 1 || board[r - 1][c - 1] == TEMP_0)) count++;
        if (r - 1 >= 0 && c + 1 < board[0].length && (board[r - 1][c + 1] == 1 || board[r - 1][c + 1] == TEMP_0)) count++;
        if (r + 1 < board.length && c - 1 >= 0 && (board[r + 1][c - 1] == 1 || board[r + 1][c - 1] == TEMP_0)) count++;
        if (r + 1 < board.length && c + 1 < board[0].length && (board[r + 1][c + 1] == 1 || board[r + 1][c + 1] == TEMP_0)) count++;

        return count;
    }
}
