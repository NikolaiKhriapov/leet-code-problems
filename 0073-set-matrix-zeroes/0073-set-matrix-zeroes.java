class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return;
        }
        
        boolean isFirstRowZero = isFirstRowZero(matrix);
        boolean isFirstColZero = isFirstColZero(matrix);
        premarkFirstRowAndFirstCol(matrix);
        markRowsAndCols(matrix);
        markFirstRowAndFirstCol(matrix, isFirstRowZero, isFirstColZero);
    }

    private boolean isFirstRowZero(int[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isFirstColZero(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                return true;
            }
        }
        return false;
    }

    private void premarkFirstRowAndFirstCol(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
    }

    private void markRowsAndCols(int[][] matrix) {
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    private void markFirstRowAndFirstCol(int[][] matrix, boolean isFirstRowZero, boolean isFirstColZero) {
        if (isFirstRowZero) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }
        if (isFirstColZero) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}