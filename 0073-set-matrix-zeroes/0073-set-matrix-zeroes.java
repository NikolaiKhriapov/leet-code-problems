class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    if (r == 0) isFirstRowZero = true;
                    if (c == 0) isFirstColZero = true;
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }
        
        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (isFirstRowZero) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[0][c] = 0;
            }
        }

        if (isFirstColZero) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}