class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                int[] curr = new int[] { i, j };
                if (recursive(board, word, 0, curr, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean recursive(char[][] board, String word, int index, int[] curr, boolean[][] visited) {        
        int r = curr[0], c = curr[1];

        if (board[r][c] != word.charAt(index)) {
            return false;
        }
        if (visited[r][c]) {
            return false;
        } 
        
        visited[r][c] = true;

        if (index == word.length() - 1) {
            return true;
        }

        int[][] options = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        for (int[] option : options) {
            int rNew = r + option[0];
            int cNew = c + option[1];
            if (rNew >= 0 && rNew <= board.length - 1 && cNew >= 0 && cNew <= board[0].length - 1) {
                if (recursive(board, word, index + 1, new int[] { rNew, cNew }, visited)) {
                    return true;
                }
            }
        }

        visited[r][c] = false;

        return false;
    }
}