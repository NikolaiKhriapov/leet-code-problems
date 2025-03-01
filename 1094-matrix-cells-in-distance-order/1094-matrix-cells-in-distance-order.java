class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] matrix = new int[rows * cols][1];
        int p = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[p++] = new int[] {r, c};
            }
        }

        Arrays.sort(matrix, (a, b) -> 
            (Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter)) -
            (Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter))
        );

        return matrix;
    }
}