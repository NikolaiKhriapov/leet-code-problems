class Solution {
    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (exist(board, 0, i, j, word, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, int index, int row, int col, String word, boolean[][] visited) {
        if (index == word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (board[row][col] != word.charAt(index)) return false;
        
        if (visited[row][col]) return false;
        visited[row][col] = true;

        boolean found = exist(board, index + 1, row + 1, col, word, visited) ||
                        exist(board, index + 1, row, col + 1, word, visited) ||
                        exist(board, index + 1, row - 1, col, word, visited) ||
                        exist(board, index + 1, row, col - 1, word, visited);

        visited[row][col] = false;
        return found;
    }
}