/**
 * TEMP_0 - 1 that became 0 -> in the next iteration must be changed to 0;
 * TEMP_1 - 0 that became 1 -> in the next iteration must be changed to 1;
 */
class Solution {
    private static final int TEMP_0 = 10;
    private static final int TEMP_1 = 11;
    private static final int[][] DIRECTIONS = {
        {-1,  0},
        { 1,  0},
        { 0, -1},
        { 0,  1},
        {-1, -1},
        {-1,  1},
        { 1, -1},
        { 1,  1} 
    };

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

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
    private static void markCell(int[][] board, int r, int c) {
        int liveNeighbors = countLiveNeighbors(board, r, c);
        if (board[r][c] == 0 && liveNeighbors == 3) {
            board[r][c] = TEMP_1;
        } else if (board[r][c] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
            board[r][c] = TEMP_0;
        }
    }

    /**
     * Unmark temporarily marked cells back to 0 or 1
     */
    private static void unmarkCell(int[][] board, int r, int c) {
        if (board[r][c] == TEMP_0) {
            board[r][c] = 0;
        } else if (board[r][c] == TEMP_1) {
            board[r][c] = 1;
        }
    }

    /**
     * Counts live neighbors (1 or TEMP_0)
     */
    private static int countLiveNeighbors(int[][] board, int r, int c) {
        int count = 0;
        for (int[] dir : DIRECTIONS) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < board.length &&
                nc >= 0 && nc < board[0].length &&
                (board[nr][nc] == 1 || board[nr][nc] == TEMP_0)) {
                count++;
            }
        }
        return count;
    }
}
