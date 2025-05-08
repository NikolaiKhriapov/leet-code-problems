class Solution {
    private static final int[][] NEIGHBORS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (board.length == 0 || board[0].length == 0 || board.length * board[0].length < word.length()) {
            return false;
        }
        if (word.isEmpty()) {
            return true;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] wordArray = word.toCharArray();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (exists(board, r, c, wordArray, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exists(char[][] board, int row, int col, char[] word, int index, boolean[][] visited) {
        if (index == word.length) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (board[row][col] != word[index] || visited[row][col]) return false;

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