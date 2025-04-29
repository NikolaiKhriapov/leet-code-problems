class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;

        int r = row;
        int c = 0;
        while (r >= 0 && c >= 0 && c <= col) {
            if (matrix[r][c] == target) {
                return true;
            }
            if (matrix[r][c] > target) {
                r--;
            } else {
                c++;
            }
        }

        return false;
    }
}