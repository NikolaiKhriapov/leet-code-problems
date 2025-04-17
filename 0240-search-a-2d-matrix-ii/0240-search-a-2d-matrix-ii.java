class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int c = 0;
        int col = 0;
        while (c < matrix[0].length && matrix[0][c] <= target) {
            col = c++;
        }
        for (int row = 0; row < matrix.length && col >= 0; row++) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
            } else {
                col--;
                row--;
            }
        }

        return false;
    }
}
