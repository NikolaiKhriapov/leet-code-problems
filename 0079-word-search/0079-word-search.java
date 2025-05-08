class Solution {
    private static final int[][] NEIGHBORS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (exists(board, r, c, word, 0, new boolean[board.length][board[0].length])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exists(char[][] board, int row, int col, String word, int index, boolean[][] visited) {
        if (index >= word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (board[row][col] != word.charAt(index) || visited[row][col]) return false;

        visited[row][col] = true;
        for (int[] neighbor : NEIGHBORS) {
            if (exists(board, row + neighbor[0], col + neighbor[1], word, index + 1, visited)) {
                return true;
            }
        }
        visited[row][col] = false;

        return false;
    }
}