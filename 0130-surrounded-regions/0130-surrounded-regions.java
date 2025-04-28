class Solution {
    public void solve(char[][] board) {

        markEdgeRegions(board);
        captureSurroundedRegions(board);
        unmarkSaveRegions(board);        
    }

    private void markEdgeRegions(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            markEdgeRegion(board, r, 0);
            markEdgeRegion(board, r, board[0].length - 1);
        }
        for (int c = 0; c < board[0].length; c++) {
            markEdgeRegion(board, 0, c);
            markEdgeRegion(board, board.length - 1, c);
        }
    }

    private void markEdgeRegion(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
            return;
        }

        board[r][c] = '.';

        markEdgeRegion(board, r + 1, c);
        markEdgeRegion(board, r, c + 1);
        markEdgeRegion(board, r - 1, c);
        markEdgeRegion(board, r, c - 1);
    }

    private void captureSurroundedRegions(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void unmarkSaveRegions(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == '.') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}