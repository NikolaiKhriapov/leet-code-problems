class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;

        for (int n : matrix[0]) {
            if (n == 0) {
                isFirstRowZero = true;
                break;
            }
        }
        for (int[] arr : matrix) {
            if (arr[0] == 0) {
                isFirstColZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0) matrix[i][j] = 0;
                if (matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (isFirstRowZero) {
                    matrix[0][j] = 0;
                }
                if (isFirstColZero) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}