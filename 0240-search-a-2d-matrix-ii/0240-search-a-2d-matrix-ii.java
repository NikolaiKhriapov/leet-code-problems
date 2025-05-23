class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            int val = matrix[row][col];
            if (val == target) return true;
            if (val > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}