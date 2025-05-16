class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / matrix[0].length][mid % matrix[0].length];

            if (midVal == target) return true;
            if (midVal > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}