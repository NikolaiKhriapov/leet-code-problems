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
        Map<String, Set<Character>> map = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++){
                String nine = String.valueOf(r / 3) + String.valueOf(c / 3);
                Set<Character> mapset = map.getOrDefault(nine, new HashSet<>());
                char ch = board[r][c];
                if (ch != '.' && !mapset.add(ch)) {
                    return false;
                }
                map.put(nine, mapset);
            }
        }

        return true;
    }
}