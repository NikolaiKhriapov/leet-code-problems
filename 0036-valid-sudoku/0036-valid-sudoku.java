class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }
        return isValidRows(board) && isValidCols(board) && isValidSubboxes(board);
    }

    private boolean isValidRows(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            boolean[] set = new boolean[board.length];
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] != '.') {
                    int idx = board[r][c] - '1';
                    if (set[idx]) {
                        return false;
                    }
                    set[idx] = true;
                }
            }
        }
        return true;
    }

    private boolean isValidCols(char[][] board) {
        for (int c = 0; c < board[0].length; c++) {
            boolean[] set = new boolean[board[0].length];
            for (int r = 0; r < board.length; r++) {
                if (board[r][c] != '.') {
                    int idx = board[r][c] - '1';                    
                    if (set[idx]) {
                        return false;
                    }
                    set[idx] = true;
                }
            }
        }
        return true;
    }

    private boolean isValidSubboxes(char[][] board) {
        for (int r = 0; r < board.length; r += 3) {    
            for (int c = 0; c < board[0].length; c += 3) {
                boolean[] set = new boolean[board.length];
                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        if (board[i][j] != '.') {
                            int idx = board[i][j] - '1';                    
                            if (set[idx]) {
                                return false;
                            }
                            set[idx] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}