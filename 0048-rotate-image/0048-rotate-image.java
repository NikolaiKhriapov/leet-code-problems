class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        transpose(matrix);
        mirror(matrix);
    }

    private void transpose(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = r; c < matrix[0].length; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }

    private void mirror(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            reverseRow(matrix[i]);
        }
    }

    private void reverseRow(int[] row) {
        for (int i = 0; i < row.length / 2; i++) {
            int temp = row[i];
            row[i] = row[row.length - 1 - i];
            row[row.length - 1 - i] = temp;
        }
    }
}