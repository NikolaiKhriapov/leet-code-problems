class Solution {
    private static final int BOARD_SIZE = 9;
    private static final char EMPTY_CELL = '.';

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != BOARD_SIZE || board.length != board[0].length) {
            throw new IllegalArgumentException("Invalid input");
        }

        return isRowsValid(board) && isColumnsValid(board) && isSubboxesValid(board);
    }

    private boolean isRowsValid(char[][] board) {
        for (int r = 0; r < BOARD_SIZE; r++) {
            Set<Character> set = new HashSet<>();
            for (int c = 0; c < BOARD_SIZE; c++) {
                if (board[r][c] != EMPTY_CELL && !set.add(board[r][c])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isColumnsValid(char[][] board) {
        for (int c = 0; c < BOARD_SIZE; c++) {
            Set<Character> set = new HashSet<>();
            for (int r = 0; r < BOARD_SIZE; r++) {
                if (board[r][c] != EMPTY_CELL && !set.add(board[r][c])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSubboxesValid(char[][] board) {
        for (int r = 0; r < BOARD_SIZE; r += 3) {
            for (int c = 0; c < BOARD_SIZE; c += 3) {
                Set<Character> set = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[r + i][c + j] != EMPTY_CELL && !set.add(board[r + i][c + j])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

// time  - O(n^2)
// space - O(n)