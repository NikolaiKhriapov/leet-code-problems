class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = binarySearch1(matrix, target, 0, matrix.length - 1);
        if (row < 0 || row >= matrix.length) {
            return false;
        }
        return binarySearch2(matrix, target, row, 0, matrix[0].length - 1);
    }

    private int binarySearch1(int[][] matrix, int target, int l, int r) {
        if (l > r) return r;

        int m = l + (r - l) / 2;

        if (matrix[m][0] == target) return m;
        if (matrix[m][0] > target) return binarySearch1(matrix, target, l, m - 1);
        else return binarySearch1(matrix, target, m + 1, r);
    }

    private boolean binarySearch2(int[][] matrix, int target, int row, int l, int r) {
        if (l > r) return false;

        int m = l + (r - l) / 2;

        if (matrix[row][m] == target) return true;
        if (matrix[row][m] > target) return binarySearch2(matrix, target, row, l, m - 1);
        else return binarySearch2(matrix, target, row, m + 1, r);
    }
}