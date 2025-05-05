class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }
        return isValidRows(board) && isValidCols(board) && isValidSubboxes(board);
    }

    private boolean isValidRows(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            Set<Character> set = new HashSet<>();
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] != '.' && !set.add(board[r][c])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidCols(char[][] board) {
        for (int c = 0; c < board[0].length; c++) {
            Set<Character> set = new HashSet<>();
            for (int r = 0; r < board.length; r++) {
                if (board[r][c] != '.' && !set.add(board[r][c])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidSubboxes(char[][] board) {
        for (int r = 0; r < board.length; r += 3) {    
            for (int c = 0; c < board[0].length; c += 3) {
                Set<Character> set = new HashSet<>();
                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        if (board[i][j] != '.' && !set.add(board[i][j])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}