class Solution {
    private final static int[][] NEIGHBORS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || board.length * board[0].length < word.length()) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        char firstChar = word.charAt(0);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == firstChar && exists(board, word, 0, row, col, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exists(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        if (index >= word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col] != word.charAt(index) || visited[row][col]) {
            return false;
        }
        
        visited[row][col] = true;
        for (int[] neighbor : NEIGHBORS) {
            if (exists(board, word, index + 1, row + neighbor[0], col + neighbor[1], visited)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}