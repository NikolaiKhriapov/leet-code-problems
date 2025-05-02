class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
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
                Set<Character> set = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[r + i][c + j] != '.' && !set.add(board[r + i][c + j])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}