class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (word.length() > 0 && (board == null || board.length == 0)) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        char firstChar = word.charAt(0);
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == firstChar && exist(board, word, r, c, visited, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, String word, int r, int c, boolean[][] visited, int currLength) {
        if (visited[r][c]) {
            return false;
        }

        char currChar = board[r][c];
        char expChar = word.charAt(currLength);
        if (currChar != expChar) {
            return false;
        }

        currLength++;
        if (currLength >= word.length()) {
            return true;
        }

        visited[r][c] = true;
        if (c - 1 >= 0 && exist(board, word, r, c - 1, visited, currLength)) {
            return true;
        }
        if (c + 1 < board[0].length && exist(board, word, r, c + 1, visited, currLength)) {
            return true;
        }
        if (r - 1 >= 0 && exist(board, word, r - 1, c, visited, currLength)) {
            return true;
        }
        if (r + 1 < board.length && exist(board, word, r + 1, c, visited, currLength)) {
            return true;
        }
        visited[r][c] = false;

        return false;
    }
}