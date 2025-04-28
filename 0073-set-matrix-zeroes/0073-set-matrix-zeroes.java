class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Invalid state"); // for simplicity
        }
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        boolean isFirstRowZeroed = isFirstRowZeroed(matrix);
        boolean isFirstColZeroed = isFirstColZeroed(matrix);

        markFirstRowAndColumn(matrix);
        updateRowsAndColumnsExceptFirst(matrix);
        updateFirstRowAndColumn(matrix, isFirstRowZeroed, isFirstColZeroed);
    }

    private boolean isFirstRowZeroed(int[][] matrix) {
        for (int c = 0; c < matrix[0].length; c++) {
            if (matrix[0][c] == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isFirstColZeroed(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r][0] == 0) {
                return true;
            }
        }
        return false;
    }

    private void markFirstRowAndColumn(int[][] matrix) {
        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
    }

    private void updateRowsAndColumnsExceptFirst(int[][] matrix) {
        for (int r = 1; r < matrix.length; r++) {
            if (matrix[r][0] == 0) {
                for (int c = 1; c < matrix[0].length; c++) {
                    matrix[r][c] = 0;
                }
            }
        }

        for (int c = 1; c < matrix[0].length; c++) {
            if (matrix[0][c] == 0) {
                for (int r = 1; r < matrix.length; r++) {
                    matrix[r][c] = 0;
                }
            }
        }
    }

    private void updateFirstRowAndColumn(int[][] matrix, boolean isFirstRowZeroed, boolean isFirstColZeroed) {
        if (isFirstRowZeroed) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[0][c] = 0;
            }
        }

        if (isFirstColZeroed) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}