class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return binarySearch(matrix, target, 0, matrix.length * matrix[0].length - 1);
    }

    private boolean binarySearch(int[][] matrix, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / matrix[0].length][mid % matrix[0].length];

            if (midVal == target) {
                return true;
            } else if (midVal > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            } 
        }
        return false;
    }
}