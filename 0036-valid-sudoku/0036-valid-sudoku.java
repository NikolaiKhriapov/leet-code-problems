class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isValidRows(board) && isValidCols(board) && isValidNines(board);
    }

    private boolean isValidRows(char[][] board) {
        for (char[] row : board) {
            Set<Character> set = new HashSet<>();
            for (char c : row) {
                if (c != '.' && !set.add(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidCols(char[][] board) {
        Set<Character>[] sets = new Set[board.length];
        for (int i = 0; i < sets.length; i++) {
            sets[i] = new HashSet<>();
        }

        for (char[] row : board) {
            for (int i = 0; i < row.length; i++) {
                char c = row[i];
                if (c != '.' && !sets[i].add(c)) {
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