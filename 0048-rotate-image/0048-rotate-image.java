class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        mirrorDiagonally(matrix);
        mirrorVertically(matrix);
    }

    private void mirrorDiagonally(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = r + 1; c < matrix[0].length; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }

    private void mirrorVertically(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length / 2; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[r][matrix[0].length - 1 - c];
                matrix[r][matrix[0].length - 1 - c] = temp;
            }
        }
    }
}