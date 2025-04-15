class Solution {
    public boolean exist(char[][] board, String word) {
        if ((board == null || board.length == 0) && word.length() > 0) return false;
        if (word == null || word.length() == 0) return true;

        char firstChar = word.charAt(0);
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == firstChar && exist(board, word, new int[]{r, c}, new boolean[board.length][board[0].length], 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, String word, int[] currCell, boolean[][] visited, int currLength) {
        if (visited[currCell[0]][currCell[1]]) return false;

        char currChar = board[currCell[0]][currCell[1]];
        char expChar = word.charAt(currLength);
        if (currChar != expChar) return false;

        currLength++;
        if (currLength >= word.length()) return true;

        int[] l = new int[]{currCell[0], currCell[1] - 1};
        int[] r = new int[]{currCell[0], currCell[1] + 1};
        int[] t = new int[]{currCell[0] - 1, currCell[1]};
        int[] b = new int[]{currCell[0] + 1, currCell[1]};

        visited[currCell[0]][currCell[1]] = true;
        if (l[1] >= 0) {
            if (exist(board, word, l, visited, currLength)) {
                return true;
            }
        }
        if (r[1] < board[0].length) {
            if (exist(board, word, r, visited, currLength)) {
                return true;
            }
        }
        if (t[0] >= 0) {
            if (exist(board, word, t, visited, currLength)) {
                return true;
            }
        }
        if (b[0] < board.length) {
            if (exist(board, word, b, visited, currLength)) {
                return true;
            }
        }
        visited[currCell[0]][currCell[1]] = false;
        currLength--;

        return false;
    }
}