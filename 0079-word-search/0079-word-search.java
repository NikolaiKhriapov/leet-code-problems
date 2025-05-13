class Solution {
    private final static int[][] NEIGHBORS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || board.length * board[0].length < word.length()) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] wordArray = word.toCharArray();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == wordArray[0] && exists(board, wordArray, 0, row, col, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exists(char[][] board, char[] wordArray, int index, int row, int col, boolean[][] visited) {
        if (index >= wordArray.length) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col] != wordArray[index] || visited[row][col]) {
            return false;
        }
        
        visited[row][col] = true;
        for (int[] neighbor : NEIGHBORS) {
            if (exists(board, wordArray, index + 1, row + neighbor[0], col + neighbor[1], visited)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}