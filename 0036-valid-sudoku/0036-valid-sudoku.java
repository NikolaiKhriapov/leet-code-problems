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
        Map<String, Set<Character>> map = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                String key = String.valueOf(r / 3) + String.valueOf(c / 3);
                Set<Character> value = map.getOrDefault(key, new HashSet<>());
                if (board[r][c] != '.' && !value.add(board[r][c])) {
                    return false;
                }
                map.put(key, value);
            }
        }
        return true;
    }

}