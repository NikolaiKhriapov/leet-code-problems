class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = binarySearchRows(matrix, target, 0, matrix.length - 1);
        if (row < 0 || row >= matrix.length) {
            return false;
        }
        return binarySearchCol(matrix, target, row, 0, matrix[0].length - 1);
    }

    private int binarySearchRows(int[][] matrix, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[mid][0] == target) {
                return mid;
            }
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean binarySearchCol(int[][] matrix, int target, int row, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}