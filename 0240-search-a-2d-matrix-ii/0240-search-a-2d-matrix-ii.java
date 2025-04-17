class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int c = 0;
        int col = 0;
        while (c < matrix[0].length && matrix[0][c] <= target) {
            col = c++;
        }

        int r = 0;
        int row = 0;
        while (r < matrix.length && matrix[r][0] <= target) {
            row = r++;
        }

        for (int i = 0; i <= row; i++) {
            if (matrix[i][col] == target) return true;
            if (matrix[i][col] > target && col > 0) {
                col--;
                i--;
            }
        }
        for (int i = 0; i <= col; i++) {
            if (matrix[row][i] == target) return true;
            if (matrix[row][i] > target && row > 0) {
                row--;
                i--;
            }
        }

        return false;
    }
}
