class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target) {
            return false;
        }

        int row = matrix.length - 1;
        int col = 0;
        while (col < matrix[0].length && row >= 0) {
            if (col < matrix[0].length && matrix[row][col] > target) {
                row--;
            } else {
                if (matrix[row][col] == target) {
                    return true;
                }
                col++;
            }
        }

        return false;
    }
}