class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length - 1;
        int col = 0;
        while (col < matrix[0].length && row >= 0) {
            int cell = matrix[row][col];
            if (cell == target) {
                return true;
            } else if (cell > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}