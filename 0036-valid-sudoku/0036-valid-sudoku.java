class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<String>();

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                char curr = board[i][j];
                if (curr != '.') {
                    if (
                        !seen.add(curr + " in row " + i) ||
                        !seen.add(curr + " in column " + j) ||
                        !seen.add(curr + " in section " + i/3 + "-" + j/3)
                    ) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}