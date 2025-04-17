class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            throw new RuntimeException("Matrix cannot be null");
        }
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int col = matrix[0].length - 1;
        for (int row = 0; row < matrix.length && col >= 0; row++) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
                row--;
            }
        }

        return false;
    }
}
