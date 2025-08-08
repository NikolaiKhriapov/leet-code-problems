class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Invalid input");
        }
        mirrorDiagonally(matrix);
        mirrorHorizontally(matrix);
    }

    private void mirrorDiagonally(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < r; c++) {              
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }

    private void mirrorHorizontally(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length / 2; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[r][matrix[0].length - 1 - c];
                matrix[r][matrix[0].length - 1 - c] = temp;
            }
        }
    }
}

// time  - O(n^2)
// space - O(1)