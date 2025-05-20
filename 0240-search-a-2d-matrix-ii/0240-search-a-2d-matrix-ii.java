class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int row = matrix.length - 1;
        int col = 0;
        while (col < matrix[0].length && row >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (col < matrix[0].length && matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}