class Solution {
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
     * 10 - 1 that became 0 -> in the next iteration must be changed to 0;
     * 11 - 0 that became 1 -> in the next iteration must be changed to 1;
     */
    private void markCell(int[][] board, int r, int c) {
        if (board[r][c] == 0) {
            int liveNeighbors = countLiveNeighbors(board, r, c);
            if (liveNeighbors == 3) {
                board[r][c] = 11;
            }
        } else if (board[r][c] == 1) {
            int liveNeighbors = countLiveNeighbors(board, r, c);
            if (liveNeighbors < 2 || liveNeighbors > 3) {
                board[r][c] = 10;
            }
        }
    }

    private void unmarkCell(int[][] board, int r, int c) {
        if (board[r][c] == 10) {
            board[r][c] = 0;
        } else if (board[r][c] == 11) {
            board[r][c] = 1;
        }
    }

    private int countLiveNeighbors(int[][] board, int r, int c) {
        int count = 0;

        if (r - 1 >= 0 && (board[r - 1][c] == 1 || board[r - 1][c] == 10)) count++;
        if (r + 1 < board.length && (board[r + 1][c] == 1 || board[r + 1][c] == 10)) count++;
        if (c - 1 >= 0 && (board[r][c - 1] == 1 || board[r][c - 1] == 10)) count++;
        if (c + 1 < board[0].length && (board[r][c + 1] == 1 || board[r][c + 1] == 10)) count++;
        if (r - 1 >= 0 && c - 1 >= 0 && (board[r - 1][c - 1] == 1 || board[r - 1][c - 1] == 10)) count++;
        if (r - 1 >= 0 && c + 1 < board[0].length && (board[r - 1][c + 1] == 1 || board[r - 1][c + 1] == 10)) count++;
        if (r + 1 < board.length && c - 1 >= 0 && (board[r + 1][c - 1] == 1 || board[r + 1][c - 1] == 10)) count++;
        if (r + 1 < board.length && c + 1 < board[0].length && (board[r + 1][c + 1] == 1 || board[r + 1][c + 1] == 10)) count++;

        return count;
    }
}
