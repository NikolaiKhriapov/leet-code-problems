class Solution {
    private static final int[][] NEIGHBORS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0) && exists(board, r, c, word, 0, new HashSet<>())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exists(char[][] board, int row, int col, String word, int index, Set<Integer> visited) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        int key = buildKey(board, row, col);
        if (board[row][col] != word.charAt(index) || visited.contains(key)) {
            return false;
        }
        visited.add(key);
        for (int[] neighbor : NEIGHBORS) {
            if (exists(board, row + neighbor[0], col + neighbor[1], word, index + 1, visited)) {
                return true;
            }
        }
        visited.remove(key);
        return false;
    }

    private int buildKey(char[][] board, int row, int col) {
        return row * board[0].length + col;
    }
}

// time  - O((m*n)^2)
// space - O(w)