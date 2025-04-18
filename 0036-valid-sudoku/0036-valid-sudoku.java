class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isValidRows(board) && isValidCols(board) && isValidNines(board);
    }

    private boolean isValidRows(char[][] board) {
        for (int r = 0; r < 9; r++) {
            Set<Character> set = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch != '.' && !set.add(ch)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidCols(char[][] board) {
        for (int r = 0; r < 9; r++) {
            Set<Character> set = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                char ch = board[c][r];
                if (ch != '.' && !set.add(ch)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidNines(char[][] board) {
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                Set<Character> set = new HashSet<>();
                for (int sr = r; sr < r + 3; sr++) {
                    for (int sc = c; sc < c + 3; sc++) {
                        char ch = board[sr][sc];
                        if (ch != '.' && !set.add(ch)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}