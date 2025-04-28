class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isRowsValid(board) && isColsValid(board) && isSubboxesValid(board);
    }

    private boolean isRowsValid(char[][] board) {
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

    private boolean isColsValid(char[][] board) {
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

    private boolean isSubboxesValid(char[][] board) {
        for (int r = 0; r < board.length; r += 3) {
            for (int c = 0; c < board[0].length; c += 3) {
                if (!isSubboxValid(board, r, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSubboxValid(char[][] board, int row, int col) {
        Set<Character> set = new HashSet<>();
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                if (board[r][c] != '.' && !set.add(board[r][c])) {
                    return false;
                }
            }
        }
        return true;
    }
}
